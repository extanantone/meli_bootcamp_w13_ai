package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.request.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.request.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.*;
import com.bootcamp.SocialMeli.exception.AlreadyFollowException;
import com.bootcamp.SocialMeli.exception.EqualsUserSellerException;
import com.bootcamp.SocialMeli.exception.NotFollowException;
import com.bootcamp.SocialMeli.exception.UserNotFoundException;
import com.bootcamp.SocialMeli.mapper.Mapper;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SocialMeliService implements ISocialMeliService{
    private final Integer CANT_DAYS_OF_2_WEEKS = 14; //cantidad de dias en 2 semanas

    @Autowired
    private ISocialMeliRepository socialMeliRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor){
        Usuario seguidor = this.socialMeliRepository.buscarUsuario(idSeguidor);
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(idVendedor);
        //TODO verificar que sea vendedor (tenga publicaciones)
        //TODO verificar que antes no lo seguia
        if(idSeguidor.equals(idVendedor)) {
            throw new EqualsUserSellerException();
        }else if(seguidor == null){
            throw new UserNotFoundException("No existe el usuario seguidor");
        }else if(vendedor == null){
            throw new UserNotFoundException("No existe el vendedor");
        }
        boolean loSigo = seguidor.getVendedoresSeguidos().contains(vendedor);
        if(loSigo){ //true = ya lo sigo
            throw new AlreadyFollowException();
        }
        seguidor.seguirVendedor(vendedor);

        return new SuccessDTO("Vendedor seguido correctamente");
    }

    @Override
    public CantSeguidoresDTO getCantSeguidores(Integer userId) {
        //TODO chequear que se le pase un vendedor
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe un vendedor con Id: " + userId);
        }
        CantSeguidoresDTO cantSeguidoresDTO = new CantSeguidoresDTO(vendedor.getUserId(), vendedor.getUserName(),
                                                    this.socialMeliRepository.buscarSeguidores(vendedor).size());

        return cantSeguidoresDTO;
    }

    @Override
    public SeguidoresDTO getSeguidores(Integer userId) {
        //TODO chequear que se le pase un vendedor
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe un vendedor con Id: " + userId);
        }

        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
        for (Usuario user : this.socialMeliRepository.buscarSeguidores(vendedor)) {
            listaUsuarioDTO.add(new UsuarioDTO(user.getUserId(), user.getUserName()));
        }

        SeguidoresDTO seguidoresDTO = new SeguidoresDTO(vendedor.getUserId(), vendedor.getUserName(), listaUsuarioDTO);
        return seguidoresDTO;
    }

    @Override
    public SeguidoresDTO getSeguidores(Integer userId, String order) {
        SeguidoresDTO seguidoresDTO = getSeguidores(userId);
        if(order.equals("name_asc")){
            seguidoresDTO.getFollowers().sort(Comparator.comparing(UsuarioDTO::getUserName));
        }else if(order.equals("name_desc")){
            seguidoresDTO.getFollowers().sort(Comparator.comparing(UsuarioDTO::getUserName).reversed());
        }else{
            throw new IllegalArgumentException("Argumento invalido en 'order'");
        }
        return seguidoresDTO;
    }

    @Override
    public SeguidosDTO getVendedoresSeguidos(Integer userId) {
        Usuario usuario = this.socialMeliRepository.buscarUsuario(userId);
        if(usuario == null){
            throw new UserNotFoundException("No existe un usuario con Id: " + userId);
        }
        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
        for (Usuario user : usuario.getVendedoresSeguidos()) {
            listaUsuarioDTO.add(new UsuarioDTO(user.getUserId(), user.getUserName()));
        }
        SeguidosDTO seguidosDTO = new SeguidosDTO(usuario.getUserId(), usuario.getUserName(), listaUsuarioDTO);
        return seguidosDTO;
    }

    @Override
    public SeguidosDTO getVendedoresSeguidos(Integer userId, String order) {
        SeguidosDTO seguidosDTO = getVendedoresSeguidos(userId);
        if(order.equals("name_asc")){
            seguidosDTO.getFollowed().sort(Comparator.comparing(UsuarioDTO::getUserName));
        }else if(order.equals("name_desc")){
            seguidosDTO.getFollowed().sort(Comparator.comparing(UsuarioDTO::getUserName).reversed());
        }else{
            throw new IllegalArgumentException("Argumento invalido en 'order'");
        }
        return seguidosDTO;
    }

    @Override
    public SuccessDTO crearPublicacion(PublicacionDTO post) {
        //TODO chequear que el user exista
        //TODO chequear que el id_post sea unico para todos los users
        //TODO chequear que la fecha sea de hoy o el pasado
        DetalleProductoDTO detalle = post.getDetail();
        Producto nuevoProducto = new Producto();

        Usuario usuario = this.socialMeliRepository.buscarUsuario(post.getUserId());
        if(usuario == null){
            throw new UserNotFoundException("No existe el usuario con Id: " + post.getUserId());
        }
        Publicacion nuevaPublicacion = mapper.publicacionDTOToPublicacion(post);
        usuario.agregarPublicacion(nuevaPublicacion);

        return new SuccessDTO("Publicacion creada correctamente.");
    }

    @Override
    public PublicacionesDTO getPublicacionesSeguidos(Integer userId) {
        //TODO chequear que el user exista
        Usuario usuario = this.socialMeliRepository.buscarUsuario(userId);
        if(usuario == null){
            throw new UserNotFoundException("No existe el usuario con Id: " + userId);
        }
        List<Usuario> seguidos = usuario.getVendedoresSeguidos();
        List<Publicacion> publicaciones = new ArrayList<>();

        //junta todas las publicaciones de todos los vendedores que sigue el usuario
        for (Usuario vendedor : seguidos) {
            publicaciones.addAll(vendedor.getPublicaciones());
        }

        List<Publicacion> publicacionesRecientes = publicaciones.stream()
                                                                .filter(x -> {
                                                                    Period periodo = x.getDate().until(LocalDate.now());
                                                                    return periodo.getDays() < CANT_DAYS_OF_2_WEEKS
                                                                            && periodo.getDays() >= 0
                                                                            && periodo.getMonths() == 0
                                                                            && periodo.getYears() == 0;
                                                                })
                                                                .collect(Collectors.toList());
        publicacionesRecientes.sort(Comparator.comparing(Publicacion::getDate).reversed());

        PublicacionesDTO publicacionesDTO = new PublicacionesDTO();
        publicacionesDTO.setUserId(usuario.getUserId());
       // publicacionesDTO.setPosts();



        return publicacionesDTO;
    }

    @Override
    public SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor) {
        Usuario seguidor = this.socialMeliRepository.buscarUsuario(idSeguidor);
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(idVendedor);
        //TODO verificar que sea vendedor (tenga publicaciones)
        //TODO verificar que antes lo seguia
        if(idSeguidor.equals(idVendedor)){ //no se puede dejar de seguir a si mismo
            throw new EqualsUserSellerException();
        }else if(seguidor == null){
            throw new UserNotFoundException("No existe el usuario seguidor");
        }else if(vendedor == null){
            throw new UserNotFoundException("No existe el vendedor");
        }
        boolean loSeguia = seguidor.dejarDeSeguirVendedor(vendedor);
        if(!loSeguia){
            throw new NotFollowException();
        }
        return new SuccessDTO("Vendedor no seguido correctamente");
    }
}
