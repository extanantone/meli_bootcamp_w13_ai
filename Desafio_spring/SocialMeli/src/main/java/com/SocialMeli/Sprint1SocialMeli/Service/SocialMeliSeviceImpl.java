package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Exception.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Usuario;
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

    @Override
    public void validarComprador(Integer id_comprador) {
        if (repositorio.getComprador(id_comprador) == null) {
            throw new NotFoundCompradorException(id_comprador);
        }
    }

    @Override
    public void validarVendedor(Integer id_vendedor) {
        if (repositorio.getVendedor(id_vendedor) == null) {
            throw new NotFoundVendedorException(id_vendedor);
        }
    }

    @Override
    public boolean serviceFollow(Integer id_comprador, Integer id_vendedor) {
        validarComprador(id_comprador);
        validarVendedor(id_vendedor);
        for (int i = 0; i < repositorio.getComprador(id_comprador).getFolloweds().size(); i++) {
            if (repositorio.getComprador(id_comprador).getFolloweds().get(i) == id_vendedor) {
                throw new DuplicateFollowedException(id_vendedor);
            }
        }
        return repositorio.follow(id_comprador, id_vendedor);
    }

     /*if(repositorio.follow(id_comprador,id_vendedor) == false)
     {
         throw new NotFoundUsuarioException(id_vendedor);
     }
     return true;*/


    @Override
    public SeguidoresDTO serviceVendedorFollowers(Integer id_vendedor) {
        validarVendedor(id_vendedor);
        int cont = 0;
        for (int i = 0; i < repositorio.getVendedor(id_vendedor).getFollowers().size(); i++) {
            cont++;
        }
        return new SeguidoresDTO(repositorio.getVendedor(id_vendedor).getUserID(),
                repositorio.getVendedor(id_vendedor).getUser_name(), cont);
    }

    @Override
    public ListadoSeguidoresDTO serviceVendedorListFollowers(Integer id_vendedor, String order) {
        validarVendedor(id_vendedor);
        List<UsuarioDTO> listafollowers = new ArrayList<UsuarioDTO>();
        for (int i = 0; i < repositorio.getVendedor(id_vendedor).getFollowers().size(); i++) {
            listafollowers.add(new UsuarioDTO(repositorio.getComprador(repositorio.getVendedor(id_vendedor).getFollowers().get(i)).getUserID(),
                    repositorio.getComprador(repositorio.getVendedor(id_vendedor).getFollowers().get(i)).getUser_name()));
        }
        if(order.equalsIgnoreCase("name_asc"))
        {listafollowers.sort(Comparator.comparing(UsuarioDTO::getUser_name));}
        else{
            if(order.equalsIgnoreCase("name_desc"))
            {listafollowers.sort(Comparator.comparing(UsuarioDTO::getUser_name).reversed());}
            else{throw new NotValidParamException(order);}
        }

        return new ListadoSeguidoresDTO(repositorio.getVendedor(id_vendedor).getUserID(),
                repositorio.getVendedor(id_vendedor).getUser_name(),listafollowers);

    }

    @Override
    public ListadoSeguidosDTO serviceCompradorListFollowed(Integer id_comprador, String order) {
        validarComprador(id_comprador);
        List<UsuarioDTO> listafollowed = new ArrayList<UsuarioDTO>();
        for (int i = 0; i < repositorio.getComprador(id_comprador).getFolloweds().size(); i++) {
            listafollowed.add(new UsuarioDTO(repositorio.getVendedor(repositorio.getComprador(id_comprador).getFolloweds().get(i)).getUserID(),
                    repositorio.getVendedor(repositorio.getComprador(id_comprador).getFolloweds().get(i)).getUser_name()));
        }
        if(order.equalsIgnoreCase("name_asc"))
        {listafollowed.sort(Comparator.comparing(UsuarioDTO::getUser_name));}
        else{
            if(order.equalsIgnoreCase("name_desc"))
            {listafollowed.sort(Comparator.comparing(UsuarioDTO::getUser_name).reversed());}
            else{throw new NotValidParamException(order);}
        }
        return new ListadoSeguidosDTO(repositorio.getComprador(id_comprador).getUserID(),
                repositorio.getComprador(id_comprador).getUser_name(),
                listafollowed);
    }

    @Override
    public boolean serviceNewPost(PublicacionDTO publi) throws Exception {
        validarVendedor(publi.getUser_id());

        for (int i = 0; i < repositorio.getPublicaciones().size(); i++) {
            if (repositorio.getPublicaciones().get(i).getId_post() == publi.getId_post()) {
                throw new DuplicatePostException(publi.getId_post());
            }
        }

        String sDate1 = publi.getDate();
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
        LocalDate fecha = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        repositorio.newPost(new Publicacion(publi.getUser_id(), publi.getId_post(), publi.getCategory(), publi.getPrice(),
                fecha, (new Producto(publi.getDetail().getProduct_id(), publi.getDetail().getProduct_name(), publi.getDetail().getType(),
                publi.getDetail().getBrand(), publi.getDetail().getColor(), publi.getDetail().getNotes()))));

        return true;

    }

    @Override
    public List<Publicacion> listadoPublicacionTotal() {

        return repositorio.getPublicaciones();


    }

    @Override
    public List<ListadoPublicacionesDTO> listadoPublicaciones(int id_user_comprador, String order) {

        validarComprador(id_user_comprador);
        List<Publicacion> publicacionesLast14Days = new ArrayList<>();
        List<ListadoPublicacionesDTO> listadoPublicacionesDTO = new ArrayList<>();
        LocalDate fechaInicio = LocalDate.now().minusDays(14);

        for (int i = 0; i < repositorio.getPublicaciones().size(); i++) {
            if (repositorio.getPublicaciones().get(i).getDate().isAfter(fechaInicio)) {
                publicacionesLast14Days.add(repositorio.getPublicaciones().get(i));}
            else {break;}}

        if(order.equalsIgnoreCase("date_desc"))
        {Collections.sort(publicacionesLast14Days, Comparator.comparing(Publicacion::getDate).reversed());}
        else{
            if(order.equalsIgnoreCase("date_asc")){Collections.sort(publicacionesLast14Days, Comparator.comparing(Publicacion::getDate));}
            else{throw new NotValidParamException(order);}}

        for (int i = 0; i < repositorio.getComprador(id_user_comprador).getFolloweds().size(); i++) {
            List<Publicacion> listaAux = new ArrayList<>();

            for (int j = 0; j < publicacionesLast14Days.size(); j++) {
                if (publicacionesLast14Days.get(j).getUser_id() == repositorio.getComprador(id_user_comprador).getFolloweds().get(i))
                {listaAux.add(publicacionesLast14Days.get(j));}}

            listadoPublicacionesDTO.add(new ListadoPublicacionesDTO(repositorio.getComprador(id_user_comprador).getFolloweds().get(i), listaAux));
        }
        return listadoPublicacionesDTO;
    }

    @Override
    public boolean serviceUnFollow(Integer id_comprador, Integer id_vendedor) {
        validarComprador(id_comprador);
        validarVendedor(id_vendedor);

        for (int i = 0; i < repositorio.getComprador(id_comprador).getFolloweds().size(); i++) {

            if (repositorio.getComprador(id_comprador).getFolloweds().get(i) == repositorio.getVendedor(id_vendedor).getUserID()) {
                return repositorio.unFollow(id_comprador, id_vendedor);
            }

        }
        throw new NotFollowException(id_vendedor);

    }
}
