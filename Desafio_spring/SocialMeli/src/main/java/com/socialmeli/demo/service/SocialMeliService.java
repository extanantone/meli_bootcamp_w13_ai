package com.socialmeli.demo.service;


import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.exceptions.Error;
import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Producto;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;
import com.socialmeli.demo.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SocialMeliService implements  ISocialMeliService{

    @Autowired
    ISocialMeliRepository SMRepositorio;

    public SocialMeliService(ISocialMeliRepository SMRepositorio) {
        this.SMRepositorio = SMRepositorio;
        SMRepositorio.addVendedores();
        SMRepositorio.addCompradores();
    }
    public RespuestaDTO follow(int id_comprado, int id_vendedor) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Comprador compra = errorComprador(id_comprado);
        Vendedor vende = errorVendedor(id_vendedor);
        Comprador yaSeguidor = SMRepositorio.buscarSeguidor(vende.getSeguidores(), id_comprado);
        if(yaSeguidor != null){
            throw new Error("El comprador "+id_comprado+" ya seguia al vendedor "+id_vendedor);
        }else{
            boolean flag =SMRepositorio.seguir(compra, vende);
            if(flag){
                rta.setMensaje("El comprador "+id_comprado+" ha al vendedor"+id_vendedor);
                rta.setStatusCode(200);
            }
        }
        return rta;
    }


    public Comprador errorComprador(int id) throws Error {
        Comprador compra = SMRepositorio.buscarComprador(id);
        if(compra == null ){
            throw new Error("El id: "+id+" para el usuario comprador que está tratando de ingresar es incorrecto");
        }
        return compra;
    }
    public Vendedor errorVendedor(int id) throws Error {
        Vendedor vende = SMRepositorio.buscarVendedor(id);
        if(vende == null ){
            throw new Error("El id: "+id+" para el usuario vendedor que está tratando de ingresar es incorrecto");
        }
        return vende;
    }
    public ProductoDTO productoDTO(Publicacion p){
        return new ProductoDTO(p.getDetalle().getId_producto(),p.getDetalle().getNombre_producto(), p.getDetalle().getTipo(), p.getDetalle().getMarca(), p.getDetalle().getColor(), p.getDetalle().getNotas());
    }
    public Producto producto(PublicacionDTO pub){
        return new Producto(pub.getDetail().getProduct_id(), pub.getDetail().getProduct_name(), pub.getDetail().getType(), pub.getDetail().getBrand(),
                pub.getDetail().getColor(), pub.getDetail().getNotes() );
    }
    public PublicacionDTO PublicacionDTO(Publicacion p, ProductoDTO producto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String formattedString = p.getFecha().format(formatter);
        return new PublicacionDTO(p.getId_user(), p.getId_publicacion(), formattedString, producto, p.getCategoria(), p.getPrecio(), p.isPromo(),p.getDescuento());
    }
    public Publicacion PublicacionNormal(PublicacionDTO pub, Producto producto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha = LocalDate.parse(pub.getDate(), formatter);
        return new Publicacion(pub.getUser_id(),pub.getId_post(),fecha,producto,pub.getCategory(), pub.getPrice(),pub.isHas_promo(),pub.getDiscount());
    }

    public FollowsDTO contar (int id_vendedor) throws Error {
        FollowsDTO rta = new FollowsDTO();
        Vendedor vende = errorVendedor(id_vendedor);
        rta.setUser_id(id_vendedor);
        rta.setUser_name(vende.getName());
        rta.setFollowers_count(vende.getSeguidores().size());
        return rta;
    }
    public SeguidoresDTO buscarSeguidores (int id, String order ) throws Error {
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
    public SeguidosDTO buscarSeguidos (int id, String order) throws Error {
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
    public RespuestaDTO addPost(PublicacionDTO pub) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto producto = producto(pub);
        Publicacion publi = PublicacionNormal(pub, producto);
        Publicacion yaPublicado = SMRepositorio.buscarPost(vende.getPublicaciones(), pub.getId_post());
        if(yaPublicado != null){
            throw new Error("El post con id "+pub.getId_post()+" ya habia sido añadido anteriormente por el vendedor "+vende.getUser_id());
        }else{
            Boolean flag = SMRepositorio.post(vende, publi);
            if(flag){
                rta.setMensaje("Se le añadió el post "+pub.getId_post()+" al vendedor "+vende.getUser_id()+" correctamente.");
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public boolean validarFecha(LocalDate fecha){
        boolean flag = false;
        LocalDate currentDate = LocalDate.now();
        long numberOFDays = DAYS.between(fecha, currentDate);
        if(numberOFDays <= 14){
            flag=true;
        }
        return flag;
    }
    public List<VendedoresDTO> addPublicaciones(int id, String order) throws Error {
        boolean flag;
        List<Publicacion> guardadas = SMRepositorio.retornarPublicaciones();
        if(order == null ||order.equals("date_asc")){
            guardadas = guardadas.stream().sorted(Comparator.comparing(x->x.getFecha())).collect(Collectors.toList());
        }else  if(order.equals("date_desc")){
            guardadas = guardadas.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getFecha()))).collect(Collectors.toList());
        }
        List<PublicacionDTO> publicacionesDTO = new ArrayList<>();
        List<VendedoresDTO>  posts = new ArrayList<>();
        Comprador compra = errorComprador(id);
        List<Vendedor> vendedores = compra.getSiguiendo();
        for(Publicacion pun:guardadas){
            for (Vendedor ve: vendedores) {
                for (Publicacion p:ve.getPublicaciones()) {
                    flag = validarFecha(p.getFecha());
                    if(flag && pun.getId_publicacion()==p.getId_publicacion()){
                        VendedoresDTO retorno = new VendedoresDTO(ve.getUser_id(), ve.getName());
                        ProductoDTO producto = productoDTO(p);
                        publicacionesDTO.add(PublicacionDTO(p, producto));
                        retorno.getPosts().add(PublicacionDTO(p, producto));
                        posts.add(retorno);
                    }
                }
            }
        }
        return posts;
    }

    public RespuestaDTO unfollow(int id_comprado, int id_vendedor) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Comprador compra = errorComprador(id_comprado);
        Vendedor vende = errorVendedor(id_vendedor);
        Comprador yaSeguidor = SMRepositorio.buscarSeguidor(vende.getSeguidores(), id_comprado);
        if(yaSeguidor == null){
            throw new Error("El comprador "+id_comprado+" no sigue al vendedor "+id_vendedor);
        }else{
            boolean flag =SMRepositorio.unfollow(compra, vende);
            if(flag){
                rta.setMensaje("El comprador "+id_comprado+" ha dejado de seguir con exito al vendedor "+id_vendedor);
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public RespuestaDTO addPromocion(PublicacionDTO pub) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto producto = producto(pub);
        Publicacion publi = PublicacionNormal(pub, producto);
        Publicacion yaPublicado = SMRepositorio.buscarPost(vende.getPublicaciones(), pub.getId_post());
        if(yaPublicado != null){
            throw new Error("El post con id "+pub.getId_post()+" ya habia sido añadido anteriormente por el vendedor "+vende.getUser_id());
        }else{
            Boolean flag = SMRepositorio.post(vende, publi);
            if(flag){
                rta.setMensaje("Se le añadió el post promocional "+pub.getId_post()+" al vendedor "+vende.getUser_id()+" correctamente.");
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public PromocionDTO contarPromocion (int id_vendedor) throws Error {
        int i=0;
        Vendedor vende = errorVendedor(id_vendedor);
        for ( Publicacion p:vende.getPublicaciones()) {
            if(p.isPromo()){
                i++;
            }
        }
        return new PromocionDTO(id_vendedor, vende.getName(), i);
    }
    public VendedoresDTO publicacionesEnPromocion (int id) throws Error {
        Vendedor vende = errorVendedor(id);
        VendedoresDTO retorno = new VendedoresDTO(vende.getUser_id(),vende.getName());
        for (Publicacion p:vende.getPublicaciones()) {
            if(p.isPromo() ){
                ProductoDTO producto = productoDTO(p);
                retorno.getPosts().add(PublicacionDTO(p,producto));
            }
        }
        return retorno;
    }

}
