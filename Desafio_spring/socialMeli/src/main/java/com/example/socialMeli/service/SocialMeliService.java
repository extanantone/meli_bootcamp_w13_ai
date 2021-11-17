package com.example.socialMeli.service;

import com.example.socialMeli.dto.*;
import com.example.socialMeli.exceptions.UsuarioNoEncontradoError;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Producto;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import com.example.socialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.temporal.ChronoUnit.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SocialMeliService implements  ISocialMeliService{

    @Autowired
    ISocialMeliRepository  SMRepositorio;

    public void cargarDatos(){
        SMRepositorio.agregarVendedores();
        SMRepositorio.agregarCompradores();
    }
    public Comprador errorComprador(int id) throws UsuarioNoEncontradoError {
        Comprador compra = SMRepositorio.buscarComprador(id);
        if(compra == null ){
            throw new UsuarioNoEncontradoError("El id: "+id+" para el usuario comprador que está tratando de ingresar es incorrecto");
        }
        return compra;
    }
    public Vendedor errorVendedor(int id) throws UsuarioNoEncontradoError {
        Vendedor vende = SMRepositorio.buscarVendedor(id);
        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id: "+id+" para el usuario vendedor que está tratando de ingresar es incorrecto");
        }
        return vende;
    }
    public ProductoDTO deProductoAProductoDTO(Publicacion p){
        return new ProductoDTO(p.getDetalle().getId_producto(),p.getDetalle().getNombre_producto(), p.getDetalle().getTipo(), p.getDetalle().getMarca(), p.getDetalle().getColor(), p.getDetalle().getNotas());
    }
    public Producto deProductoDTOAProducto(PublicacionDTO pub){
        return new Producto(pub.getDetail().getProduct_id(), pub.getDetail().getProduct_name(), pub.getDetail().getType(), pub.getDetail().getBrand(),
                pub.getDetail().getColor(), pub.getDetail().getNotes() );
    }
    public PublicacionDTO crearPublicacionDTO(Publicacion p, ProductoDTO producto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String formattedString = p.getFecha().format(formatter);
        return new PublicacionDTO(p.getId_user(), p.getId_publicacion(), formattedString, producto, p.getCategoria(), p.getPrecio(), p.isPromo(),p.getDescuento());
    }
    public Publicacion crearPublicacionNormal(PublicacionDTO pub, Producto producto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha = LocalDate.parse(pub.getDate(), formatter);
        return new Publicacion(pub.getUser_id(),pub.getId_post(),fecha,producto,pub.getCategory(), pub.getPrice(),pub.isHas_promo(),pub.getDiscount());
    }
    public RespuestaSimpleDTO seguir (int id_comprado, int id_vendedor) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Comprador compra = errorComprador(id_comprado);
        Vendedor vende = errorVendedor(id_vendedor);
        Comprador yaSeguidor = SMRepositorio.buscarSeguidor(vende.getSeguidores(), id_comprado);
        if(yaSeguidor != null){
            throw new UsuarioNoEncontradoError("El comprador "+id_comprado+" ya seguia al vendedor "+id_vendedor);
        }else{
            boolean flag =SMRepositorio.seguir(compra, vende);
            if(flag){
                rta.setMensaje("El comprador "+id_comprado+" ha seguido con exito al vendedor "+id_vendedor);
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public CantidadFollowsDTO contar (int id_vendedor) throws UsuarioNoEncontradoError {
        CantidadFollowsDTO rta = new CantidadFollowsDTO();
        Vendedor vende = errorVendedor(id_vendedor);
        rta.setUser_id(id_vendedor);
        rta.setUser_name(vende.getName());
        rta.setFollowers_count(vende.getSeguidores().size());
        return rta;
    }
    public SeguidoresDTO buscarSeguidores (int id, String order ) throws UsuarioNoEncontradoError{
        SeguidoresDTO seguidores = new SeguidoresDTO();
        Vendedor vende = errorVendedor(id);
        seguidores.setUser_id(id);
        seguidores.setUser_name(vende.getName());
        List<CompradoresDTO> compradoresQueSiguen = new ArrayList<>();
        for (Comprador c:vende.getSeguidores()) {
            compradoresQueSiguen.add(new CompradoresDTO(c.getUser_id(),c.getName()));
        }
        if(order == null ||order.equals("name_asc")){
            seguidores.setFollowers(compradoresQueSiguen.stream().sorted(Comparator.comparing(x->x.getUser_name())).collect(Collectors.toList()));
        }else  if(order.equals("name_desc")){
            seguidores.setFollowers(compradoresQueSiguen.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getUser_name()))).collect(Collectors.toList()));
        }
        return seguidores;
    }
    public SeguidosDTO buscarSeguidos (int id, String order) throws UsuarioNoEncontradoError{
        SeguidosDTO seguidos = new SeguidosDTO();
        Comprador compra = errorComprador(id);
        seguidos.setUser_id(id);
        seguidos.setUser_name(compra.getName());
        List<CompradoresDTO> vendedoresQueSiguen = new ArrayList<>();
        for (Vendedor c:compra.getSiguiendo()) {
            vendedoresQueSiguen.add(new CompradoresDTO(c.getUser_id(),c.getName()));
        }
        if(order == null ||order.equals("name_asc")){
            seguidos.setFollowed(vendedoresQueSiguen.stream().sorted(Comparator.comparing(x->x.getUser_name())).collect(Collectors.toList()));
        }else  if(order.equals("name_desc")){
            seguidos.setFollowed(vendedoresQueSiguen.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getUser_name()))).collect(Collectors.toList()));
        }
        return seguidos;
    }
    public RespuestaSimpleDTO añadirPost (PublicacionDTO pub) throws UsuarioNoEncontradoError{
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto producto = deProductoDTOAProducto(pub);
        Publicacion publi = crearPublicacionNormal(pub, producto);
        Publicacion yaPublicado = SMRepositorio.buscarPost(vende.getPublicaciones(), pub.getId_post());
        if(yaPublicado != null){
            throw new UsuarioNoEncontradoError("El post con id "+pub.getId_post()+" ya habia sido añadido anteriormente por el vendedor "+vende.getUser_id());
        }else{
            Boolean flag = SMRepositorio.postear(vende, publi);
            if(flag){
                rta.setMensaje("Se le añadió el post "+pub.getId_post()+" al vendedor "+vende.getUser_id()+" correctamente.");
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public boolean verificarVendedorYFecha(LocalDate fecha){
        boolean flag = false;
        LocalDate currentDate = LocalDate.now();
        long numberOFDays = DAYS.between(fecha, currentDate);
        if(numberOFDays <= 14){
            flag=true;
        }
        return flag;
    }
    public List<Publicacion>ordenar(List<Publicacion> guardadas, String order){
        if(order == null ||order.equals("date_asc")){
            guardadas = guardadas.stream().sorted(Comparator.comparing(x->x.getFecha())).collect(Collectors.toList());
        }else  if(order.equals("date_desc")){
            guardadas = guardadas.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getFecha()))).collect(Collectors.toList());
        }
        return guardadas;
    }
    public boolean verificaTamaño(List<?> lista){
        boolean flag = false;
        if(lista.size()!=0){
            flag=true;
        }
        return flag;
    }
    public List<Publicacion> obtenerPublicacionesDeVendedoresQueSigo(List<Vendedor> vendedores, String order){
        List<Publicacion> posts = new ArrayList<>();
        for (Vendedor v: vendedores) {
            for (Publicacion p: v.getPublicaciones()) {
                posts.add(p);
            }
        }
        posts = ordenar(posts, order);
        return posts;
    }
    public List<PublicacionesVendedoresDTO> obtenerPublicaciones (int id, String order) throws UsuarioNoEncontradoError{
        boolean flag, entra = true;
        List<PublicacionesVendedoresDTO>  posts = new ArrayList<>();
        Comprador compra = errorComprador(id);
        List<Vendedor> vendedores = compra.getSiguiendo();
        List<Publicacion> guardadas = obtenerPublicacionesDeVendedoresQueSigo(vendedores, order);
        while(guardadas.size()>0 && entra){
            entra=verificaTamaño(vendedores);
            for (Vendedor ve: vendedores) {
                PublicacionesVendedoresDTO retorno = new PublicacionesVendedoresDTO(ve.getUser_id(), ve.getName());
                List<Publicacion> publi = ordenar(ve.getPublicaciones(), order);
                entra=verificaTamaño(publi);
                for (Publicacion p:publi) {
                    if(guardadas.size()!=0){
                        flag = verificarVendedorYFecha(guardadas.get(0).getFecha());
                        if(flag && guardadas.get(0).getId_publicacion()== p.getId_publicacion() && guardadas.get(0).getId_user() == ve.getUser_id() ){
                            ProductoDTO producto = deProductoAProductoDTO(p);
                            retorno.getPosts().add(crearPublicacionDTO(p, producto));
                            guardadas.remove(0);
                        }else if(!flag){
                            guardadas.remove(0);
                        }
                    }
                }
                if(retorno.getPosts().size()!=0){
                    posts.add(retorno);
                }
            }
        }
        return posts;
    }

    public RespuestaSimpleDTO dejarDeSeguir (int id_comprado, int id_vendedor) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Comprador compra = errorComprador(id_comprado);
        Vendedor vende = errorVendedor(id_vendedor);
        Comprador yaSeguidor = SMRepositorio.buscarSeguidor(vende.getSeguidores(), id_comprado);
        if(yaSeguidor == null){
            throw new UsuarioNoEncontradoError("El comprador "+id_comprado+" no sigue al vendedor "+id_vendedor);
        }else{
            boolean flag =SMRepositorio.dejarDeSeguir(compra, vende);
            if(flag){
                rta.setMensaje("El comprador "+id_comprado+" ha dejado de seguir con exito al vendedor "+id_vendedor);
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public RespuestaSimpleDTO añadirPostPromocion (PublicacionDTO pub) throws UsuarioNoEncontradoError{
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto producto = deProductoDTOAProducto(pub);
        Publicacion publi = crearPublicacionNormal(pub, producto);
        Publicacion yaPublicado = SMRepositorio.buscarPost(vende.getPublicaciones(), pub.getId_post());
        if(yaPublicado != null){
            throw new UsuarioNoEncontradoError("El post con id "+pub.getId_post()+" ya habia sido añadido anteriormente por el vendedor "+vende.getUser_id());
        }else{
            Boolean flag = SMRepositorio.postear(vende, publi);
            if(flag){
                rta.setMensaje("Se le añadió el post promocional "+pub.getId_post()+" al vendedor "+vende.getUser_id()+" correctamente.");
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public CantidadPromosDTO contarPromocion (int id_vendedor) throws UsuarioNoEncontradoError {
        int i=0;
        Vendedor vende = errorVendedor(id_vendedor);
        for ( Publicacion p:vende.getPublicaciones()) {
            if(p.isPromo()){
                i++;
            }
        }
        return new CantidadPromosDTO(id_vendedor, vende.getName(), i);
    }
    public PublicacionesVendedoresDTO publicacionesEnPromocion (int id) throws UsuarioNoEncontradoError{
        Vendedor vende = errorVendedor(id);
        PublicacionesVendedoresDTO retorno = new PublicacionesVendedoresDTO(vende.getUser_id(),vende.getName());
           for (Publicacion p:vende.getPublicaciones()) {
                if(p.isPromo() ){
                     ProductoDTO producto = deProductoAProductoDTO(p);
                     retorno.getPosts().add(crearPublicacionDTO(p,producto));
                }
           }
        return retorno;
    }
    public List<PublicacionDTO> publicacionesPorTipo(String tipo) throws UsuarioNoEncontradoError {
        boolean flag = false;
        List<Publicacion> todas = SMRepositorio.retornarPublicaciones();
        List<PublicacionDTO> publicacionesDTO = new ArrayList<>();
        for (Publicacion p:todas) {
            if(p.getDetalle().getTipo().toLowerCase().equals(tipo.toLowerCase()) ){
                ProductoDTO producto = deProductoAProductoDTO(p);
                publicacionesDTO.add(crearPublicacionDTO(p, producto));
                flag=true;
            }
        }
        if (!flag){
            throw new UsuarioNoEncontradoError("No hay ninguna publicación con el tipo que está tratando de buscar.");
        }
        return publicacionesDTO;
    }
}
