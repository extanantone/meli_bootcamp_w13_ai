package com.socialmeli.demo.service;


import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.exceptions.Error;
import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Producto;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;
import com.socialmeli.demo.repository.ISocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SocialService implements ISocialService {

    @Autowired
    ISocialRepository repo;

    public SocialService(ISocialRepository repo) {
        this.repo = repo;
        repo.addVendedores();
        repo.addCompradores();
    }
    public RespuestaDTO follow(Integer id_comprado, Integer id_vendedor) throws Error {
        RespuestaDTO Respuesta = new RespuestaDTO();
        Comprador compra = errorComprador(id_comprado);
        Vendedor vende = errorVendedor(id_vendedor);
        Comprador following = repo.buscarSeguidor(vende.getSeguidores(), id_comprado);
        if(following != null){
            throw new Error("El comprador "+id_comprado+" ya seguia al vendedor "+id_vendedor);
        }else{
            boolean flag =repo.seguir(compra, vende);
            if(flag){
                Respuesta.setMensaje("El comprador "+id_comprado+" sigue al vendedor"+id_vendedor);
                Respuesta.setStatusCode(200);
            }
        }
        return Respuesta;
    }


    public Comprador errorComprador(Integer id) throws Error {
        Comprador compra = repo.buscarComprador(id);
        if(compra == null ){
            throw new Error("El id: "+id+" es incorrecto");
        }
        return compra;
    }
    public Vendedor errorVendedor(Integer id) throws Error {
        Vendedor vende = repo.buscarVendedor(id);
        if(vende == null ){
            throw new Error("El id: "+id+" es incorrecto");
        }
        return vende;
    }
    public ProductoDTO productoDTO(Publicacion p){
        return new ProductoDTO(p.getDetalle().getId_producto(),p.getDetalle().getNombre_producto(), p.getDetalle().getTipo(), p.getDetalle().getMarca(), p.getDetalle().getColor(), p.getDetalle().getNotas());
    }
    public Producto producto(PublicacionDTO pub){
        return new Producto(pub.getDetail().getProduct_id(), pub.getDetail().getProduct_name(), pub.getDetail().getProduct_type(), pub.getDetail().getBrand(),
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


    public SeguidoresDTO buscarSeguidores (Integer id, String order ) throws Error {
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
    public SeguidoresDTO buscarSeguidos (Integer id, String order) throws Error {
        SeguidoresDTO seguidos = new SeguidoresDTO();
        Comprador compra = errorComprador(id);
        seguidos.setUser_id(id);
        seguidos.setUser_name(compra.getName());
        List<CompradoresDTO> vendedoresQueSiguen = new ArrayList<>();
        for (Vendedor c:compra.getSiguiendo()) {
            vendedoresQueSiguen.add(new CompradoresDTO(c.getUser_id(),c.getName()));
        }
        if(order == null ||order.equals("name_asc")){
            seguidos.setFollowers(vendedoresQueSiguen.stream().sorted(Comparator.comparing(x->x.getUser_name())).collect(Collectors.toList()));
        }else  if(order.equals("name_desc")){
            seguidos.setFollowers(vendedoresQueSiguen.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getUser_name()))).collect(Collectors.toList()));
        }
        return seguidos;
    }
    public RespuestaDTO addPost(PublicacionDTO pub) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto producto = producto(pub);
        Publicacion publi = PublicacionNormal(pub, producto);
        Publicacion yaPublicado = repo.buscarPost(vende.getPublicaciones(), pub.getId_post());
        if(yaPublicado != null){
            throw new Error("El post con id "+pub.getId_post()+" ya existe el vendedor "+vende.getUser_id());
        }else{
            Boolean flag = repo.post(vende, publi);
            if(flag){
                rta.setMensaje("Se añadió el post "+pub.getId_post()+" al vendedor "+vende.getUser_id()+" correctamente.");
                rta.setStatusCode(200);
            }
        }
        return rta;
    }


    public List<VendedoresDTO> addPublicaciones(Integer id, String order) throws Error {


        boolean entra = true;
        List<VendedoresDTO>  posts = new ArrayList<>();
        Comprador compra = errorComprador(id);
        List<Vendedor> vendedores = compra.getSiguiendo();
        List<Publicacion> guardadas = obtenerPublicacionesDeVendedoresQueSigo(vendedores, order);
        while(guardadas.size()>0 && entra){
            entra=verificaTamaño(vendedores);
            for (Vendedor ve: vendedores) {
                VendedoresDTO retorno = new VendedoresDTO(ve.getUser_id(), ve.getName());
                List<Publicacion> publi = ordenar(ve.getPublicaciones(), order);
                entra=verificaTamaño(publi);
                for (Publicacion p:publi) {
                    if(guardadas.size()!=0 &&guardadas.get(0).getId_publicacion()== p.getId_publicacion() && guardadas.get(0).getId_user() == ve.getUser_id() ){
                        ProductoDTO producto = productoDTO(p);
                        retorno.getPosts().add(PublicacionDTO(p, producto));
                        guardadas.remove(0);
                    }
                }
                if(retorno.getPosts().size()!=0){
                    posts.add(retorno);
                }
            }
        }
        return posts;



    }
    public List<Publicacion> obtenerPublicacionesDeVendedoresQueSigo(List<Vendedor> vendedores, String order){
        List<Publicacion> posts = new ArrayList<>();
        for (Vendedor v: vendedores) {
            for (Publicacion p: v.getPublicaciones()) {
                if(validarFecha(p.getFecha())){
                    posts.add(p);
                }
            }
        }
        posts = ordenar(posts, order);
        return posts;
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
    public List<Publicacion>ordenar(List<Publicacion> guardadas, String order){
        if(order == null ||order.equals("date_asc")){
            guardadas = guardadas.stream().sorted(Comparator.comparing(x->x.getFecha())).collect(Collectors.toList());
        }else  if(order.equals("date_desc")){
            guardadas = guardadas.stream().sorted(Collections.reverseOrder(Comparator.comparing(x->x.getFecha()))).collect(Collectors.toList());
        }
        return guardadas;
    }


    public RespuestaDTO unfollow(Integer id_comprado, Integer id_vendedor) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Comprador compra = errorComprador(id_comprado);
        Vendedor vende = errorVendedor(id_vendedor);
        Comprador yaSeguidor = repo.buscarSeguidor(vende.getSeguidores(), id_comprado);
        if(yaSeguidor == null){
            throw new Error("El comprador "+id_comprado+" no sigue al vendedor "+id_vendedor);
        }else{
            boolean flag =repo.unfollow(compra, vende);
            if(flag){
                rta.setMensaje("El comprador "+id_comprado+" ha dejado de seguir con exito al vendedor "+id_vendedor);
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public VendedoresDTO publicacionesEnPromocion (Integer id) throws Error {
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
    public PromocionDTO contarPromocion (Integer id_vendedor) throws Error {
        Integer i=0;
        Vendedor vende = errorVendedor(id_vendedor);
        for ( Publicacion p:vende.getPublicaciones()) {
            if(p.isPromo()){
                i++;
            }
        }
        return new PromocionDTO(id_vendedor, vende.getName(), i);
    }
    public RespuestaDTO addPromocion(PublicacionDTO pub) throws Error {
        RespuestaDTO rta = new RespuestaDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto producto = producto(pub);
        Publicacion publi = PublicacionNormal(pub, producto);
        Publicacion yaPublicado = repo.buscarPost(vende.getPublicaciones(), pub.getId_post());
        if(yaPublicado != null){
            throw new Error("El post con id "+pub.getId_post()+" ya existe para el vendedor"+vende.getUser_id());
        }else{
            Boolean flag = repo.post(vende, publi);
            if(flag){
                rta.setMensaje("Se  añadió el post promocional "+pub.getId_post()+" al vendedor "+vende.getUser_id()+" correctamente.");
                rta.setStatusCode(200);
            }
        }
        return rta;
    }
    public FollowsDTO contar (Integer id_vendedor) throws Error {
        FollowsDTO rta = new FollowsDTO();
        Vendedor vende = errorVendedor(id_vendedor);
        rta.setUser_id(id_vendedor);
        rta.setUser_name(vende.getName());
        rta.setFollowers_count(vende.getSeguidores().size());
        return rta;
    }

    public boolean verificaTamaño(List<?> lista){
        boolean flag = false;
        if(lista.size()!=0){
            flag=true;
        }
        return flag;
    }


}
