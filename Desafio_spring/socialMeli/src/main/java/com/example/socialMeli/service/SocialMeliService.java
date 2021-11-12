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
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit.*;

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
            throw new UsuarioNoEncontradoError("El id del usuario comprador es incorrecto");
        }
        return compra;
    }
    public Vendedor errorVendedor(int id) throws UsuarioNoEncontradoError {
        Vendedor vende = SMRepositorio.buscarVendedor(id);
        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id del usuario vendedor es incorrecto");
        }
        return vende;
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
    public SeguidoresDTO buscarSeguidores (int id) throws UsuarioNoEncontradoError{
        SeguidoresDTO seguidores = new SeguidoresDTO();
        Vendedor vende = errorVendedor(id);
        seguidores.setUser_id(id);
        seguidores.setUser_name(vende.getName());
        List<CompradoresDTO> compradoresQueSiguen = new ArrayList<>();
        for (Comprador c:vende.getSeguidores()) {
            compradoresQueSiguen.add(new CompradoresDTO(c.getUser_id(),c.getName()));
        }
        seguidores.setFollowers(compradoresQueSiguen);
        return seguidores;
    }
    public SeguidosDTO buscarSeguidos (int id) throws UsuarioNoEncontradoError{
        SeguidosDTO seguidos = new SeguidosDTO();
        Comprador compra = errorComprador(id);
        seguidos.setUser_id(id);
        seguidos.setUser_name(compra.getName());
        List<CompradoresDTO> vendedoresQueSiguen = new ArrayList<>();
        for (Vendedor c:compra.getSiguiendo()) {
            vendedoresQueSiguen.add(new CompradoresDTO(c.getUser_id(),c.getName()));
        }
        seguidos.setFollowed(vendedoresQueSiguen);
        return seguidos;
    }
    public RespuestaSimpleDTO añadirPost (PublicacionDTO pub) throws UsuarioNoEncontradoError{
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Vendedor vende = errorVendedor(pub.getUser_id());
        Producto productos = new Producto(pub.getDetail().getProduct_id(), pub.getDetail().getProduct_name(), pub.getDetail().getType(), pub.getDetail().getBrand(),
                                           pub.getDetail().getColor(), pub.getDetail().getNotes() );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha = LocalDate.parse(pub.getDate(), formatter);
        Publicacion publi = new Publicacion(pub.getUser_id(),pub.getId_post(),fecha,productos,pub.getCategory(), pub.getPrice());
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
    public List<PublicacionesVendedoresDTO> obtenerPublicaciones (int id) throws UsuarioNoEncontradoError{
        boolean flag;
        List<PublicacionDTO> publicacionesDTO = new ArrayList<>();
        List<PublicacionesVendedoresDTO>  posts = new ArrayList<>();
        Comprador compra = errorComprador(id);
        List<Vendedor> vendedores = compra.getSiguiendo();
        for (Vendedor ve: vendedores) {
            PublicacionesVendedoresDTO retorno = new PublicacionesVendedoresDTO(ve.getUser_id());
            for (Publicacion p:ve.getPublicaciones()) {
                flag = verificarVendedorYFecha(p.getFecha());
                if(flag){
                    ProductoDTO producto = new ProductoDTO(p.getDetalle().getId_producto(),p.getDetalle().getNombre_producto(), p.getDetalle().getTipo(), p.getDetalle().getMarca(), p.getDetalle().getColor(), p.getDetalle().getNotas());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
                    String formattedString = p.getFecha().format(formatter);
                    publicacionesDTO.add(new PublicacionDTO(p.getId_user(), p.getId_publicacion(), formattedString, producto, p.getCategoria(), p.getPrecio()));
                    retorno.getPosts().add(new PublicacionDTO(p.getId_user(), p.getId_publicacion(), formattedString, producto, p.getCategoria(), p.getPrecio()));
                }
            }
            posts.add(retorno);
        }
        return posts;
    }
}
