package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Exception.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


@Service
public class SocialMeliSeviceImpl implements ISocialMeliService {

    final
    ISocialMeliRepository repositorio;

    public SocialMeliSeviceImpl(ISocialMeliRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override // METODO PARA VALIDAR SI EXISTE COMPRADOR
    public boolean validarComprador(Integer id_comprador) {
        if (repositorio.getComprador(id_comprador) == null) {
            throw new NotFoundCompradorException(id_comprador);
        }
        else{return true;}
    }

    @Override // METODO PARA VALIDAR SI EXISTE VENDEDOR
    public boolean validarVendedor(Integer id_vendedor) {
        if (repositorio.getVendedor(id_vendedor) == null) {
            throw new NotFoundVendedorException(id_vendedor); }
        else{return true;}
    }

    @Override //US-01 Sprint 1
    public void serviceFollow(Integer id_comprador, Integer id_vendedor) {
        validarComprador(id_comprador);
        validarVendedor(id_vendedor);
        //Control de que comprador no siga todavia a vendedor.
        for (int i = 0; i < repositorio.getComprador(id_comprador).getFolloweds().size(); i++) {
            if (repositorio.getComprador(id_comprador).getFolloweds().get(i) == id_vendedor) {
                throw new DuplicateFollowedException(id_vendedor);}}
        //Llamo a metodo de repositorio para que registe el cambio.
        repositorio.follow(id_comprador, id_vendedor); }

    @Override // US-02 Sprint 1
    public CountSeguidoresDTO serviceCountVendedorFollowers(Integer id_vendedor) {
        validarVendedor(id_vendedor);
        int cont = 0;

        //Recorro lista de seguidores de un vendedor y se cuentan.
        for (int i = 0; i < repositorio.getVendedor(id_vendedor).getFollowers().size(); i++) {
            cont++;}
        return new CountSeguidoresDTO(repositorio.getVendedor(id_vendedor).getUserID(),
                repositorio.getVendedor(id_vendedor).getUser_name(), cont);}

    @Override // US-03 y US-08 Sprint 1
    public SeguidoresDTO serviceVendedorListFollowers(Integer id_vendedor, String order) {
        validarVendedor(id_vendedor);
        if(!order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")){throw new NotValidParamException(order);}
        List<UsuarioDTO> listafollowers = new ArrayList<>();

        //Recorro lista de followers del vendedor recibido por parametro y genero una lista de "UsuariosDTO" de cada seguidor.
        for (int i = 0; i < repositorio.getVendedor(id_vendedor).getFollowers().size(); i++) {
            listafollowers.add(new UsuarioDTO(repositorio.getComprador(repositorio.getVendedor(id_vendedor).getFollowers().get(i)).getUserID(),
                    repositorio.getComprador(repositorio.getVendedor(id_vendedor).getFollowers().get(i)).getUser_name())); }

        // ORDENAMIENTO US-08
        if(order.equalsIgnoreCase("name_asc"))
        {listafollowers.sort(Comparator.comparing(UsuarioDTO::getUser_name));}
        else{listafollowers.sort(Comparator.comparing(UsuarioDTO::getUser_name).reversed());}

        //Retorno de la lista
        return new SeguidoresDTO(repositorio.getVendedor(id_vendedor).getUserID(),
                repositorio.getVendedor(id_vendedor).getUser_name(),listafollowers);

    }

    @Override // US-04 y US-08 Sprint 1
    public SeguidosDTO serviceCompradorListFollowed(Integer id_comprador, String order) {
        validarComprador(id_comprador);
        if(!order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")){throw new NotValidParamException(order);}
        List<UsuarioDTO> listafollowed = new ArrayList<>();

        //Recorro lista de followeds del comprador recibido por parametro y genero una lista de "UsuariosDTO" de comprador que sigue.
        for (int i = 0; i < repositorio.getComprador(id_comprador).getFolloweds().size(); i++) {
            listafollowed.add(new UsuarioDTO(repositorio.getVendedor(repositorio.getComprador(id_comprador).getFolloweds().get(i)).getUserID(),
                    repositorio.getVendedor(repositorio.getComprador(id_comprador).getFolloweds().get(i)).getUser_name())); }

        // ORDENAMIENTO US-08
        if(order.equalsIgnoreCase("name_asc")) // Ordenamiento ASC O DESC DEL US-08
        {listafollowed.sort(Comparator.comparing(UsuarioDTO::getUser_name));}
        else{listafollowed.sort(Comparator.comparing(UsuarioDTO::getUser_name).reversed());}

        //Retorno de la lista
        return new SeguidosDTO(repositorio.getComprador(id_comprador).getUserID(),
                repositorio.getComprador(id_comprador).getUser_name(),
                listafollowed);
    }

    @Override // US-05 Sprint 1
    public void serviceNewPost(PublicacionDTO publi) throws Exception {
        validarVendedor(publi.getUser_id());

        for (int i = 0; i < repositorio.getPublicaciones().size(); i++) {
            if (repositorio.getPublicaciones().get(i).getId_post() == publi.getId_post()) {
                throw new DuplicatePostException(publi.getId_post());
            }
        }

        String sDate1 = publi.getDate(); // Transformacion de fecha de String a LocalDate
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
        LocalDate fecha = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        repositorio.newPost(new Publicacion(publi.getUser_id(), publi.getId_post(), publi.getCategory(), publi.getPrice(),
                fecha, (new Producto(publi.getDetail().getProduct_id(), publi.getDetail().getProduct_name(), publi.getDetail().getType(),
                publi.getDetail().getBrand(), publi.getDetail().getColor(), publi.getDetail().getNotes()))));



    }

    @Override // PRUEBA --- Metodo de prueba para ver listado total de publicaciones existentes.
    public List<Publicacion> serviceListadoCompletoPublicaciones() {
        return repositorio.getPublicaciones(); }

    @Override // US-06 u US-09 Sprint 1
    public List<PublicacionesDTO> serviceListadoPublicaciones(int id_user_comprador, String order) {

        validarComprador(id_user_comprador);
        if(!order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc")){throw new NotValidParamException(order);}

        List<Publicacion> publicacionesLast14Days = new ArrayList<>();
        List<PublicacionesDTO> listadoPublicacionesDTO = new ArrayList<>();
        LocalDate fechaInicio = LocalDate.now().minusDays(14);

        //OBTENGO TODAS LAS PUBLICACIONES DE LOS ULTIMOS 14 DIAS
        for (int i = 0; i < repositorio.getPublicaciones().size(); i++) {
            if (repositorio.getPublicaciones().get(i).getDate().isAfter(fechaInicio)) {
                publicacionesLast14Days.add(repositorio.getPublicaciones().get(i));}}

        //ORDENO EL LISTADO DE PUBLICACIONES DE LOS ULTIMOS 14 DIAS SEGUN CRITERIO RECIBIDO POR PARAMETRO
        if(order.equalsIgnoreCase("date_desc"))
        {Collections.sort(publicacionesLast14Days, Comparator.comparing(Publicacion::getDate).reversed());}
        else{Collections.sort(publicacionesLast14Days, Comparator.comparing(Publicacion::getDate));}


        //FILTRO DEL LISTADO SOLAMENTE LAS PUBLICACIONES DE VENDEDORES QUE SIGUE EL COMPRADOR RECIBIDO POR PARAMETRO
       for (int i = 0; i < repositorio.getComprador(id_user_comprador).getFolloweds().size(); i++) {
            List<Publicacion> listaAux = new ArrayList<>();
            for (int j = 0; j < publicacionesLast14Days.size(); j++) {
                 if (publicacionesLast14Days.get(j).getUser_id() == repositorio.getComprador(id_user_comprador).getFolloweds().get(i))
                 {listaAux.add(publicacionesLast14Days.get(j));}
            }
            if(!listaAux.isEmpty())
            {listadoPublicacionesDTO.add(new PublicacionesDTO(repositorio.getComprador(id_user_comprador).getFolloweds().get(i), listaAux));}
         }

        //RETORNO EL LISTADO
        return listadoPublicacionesDTO;
    }

    @Override // US-07 Sprint 1
    public void serviceUnFollow(Integer id_comprador, Integer id_vendedor) {
        validarComprador(id_comprador);
        validarVendedor(id_vendedor);
        boolean band = false;
        //Control de que comprador siga a vendedor.
        for (int i = 0; i < repositorio.getComprador(id_comprador).getFolloweds().size(); i++) {

            if (repositorio.getComprador(id_comprador).getFolloweds().get(i) == id_vendedor) {
                repositorio.unFollow(id_comprador, id_vendedor); //Llamo a metodo de repositorio para que registe el cambio.
                band=true;}
        }
        if(band==false){throw new NotFollowException(id_vendedor);} //Se ejecuta solamente si comprador no sigue a vendedor
    }
}
