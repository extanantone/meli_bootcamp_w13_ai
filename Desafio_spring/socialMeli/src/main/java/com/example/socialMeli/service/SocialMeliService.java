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

@Service
public class SocialMeliService implements  ISocialMeliService{

    @Autowired
    ISocialMeliRepository  SMRepositorio;

    public void cargarDatos(){
        SMRepositorio.agregarVendedores();
        SMRepositorio.agregarCompradores();
    }

    public RespuestaSimpleDTO seguir (int id_comprado, int id_vendedor) throws UsuarioNoEncontradoError {
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO();
        Comprador compra = SMRepositorio.buscarComprador(id_comprado);
        Vendedor vende = SMRepositorio.buscarVendedor(id_vendedor);

        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id del usuario vendedor es incorrecto");
        }else if(compra == null){
            throw new UsuarioNoEncontradoError("El id del usuario comprador es incorrecto");
        }
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
        Vendedor vende = SMRepositorio.buscarVendedor(id_vendedor);
        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id del usuario vendedor es incorrecto");
        }
        rta.setUser_id(id_vendedor);
        rta.setUser_name(vende.getName());
        rta.setFollowers_count(vende.getSeguidores().size());
        return rta;
    }
    public SeguidoresDTO buscarSeguidores (int id) throws UsuarioNoEncontradoError{
        SeguidoresDTO seguidores = new SeguidoresDTO();
        Vendedor vende = SMRepositorio.buscarVendedor(id);
        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id del usuario vendedor es incorrecto");
        }
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
        Comprador compra = SMRepositorio.buscarComprador(id);
        if(compra == null ){
            throw new UsuarioNoEncontradoError("El id del usuario comprador es incorrecto");
        }
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
        Vendedor vende = SMRepositorio.buscarVendedor(pub.getUser_id());
        if(vende == null ){
            throw new UsuarioNoEncontradoError("El id del usuario vendedor es incorrecto");
        }
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
}
