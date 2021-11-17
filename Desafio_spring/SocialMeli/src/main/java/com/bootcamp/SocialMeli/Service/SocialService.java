package com.bootcamp.SocialMeli.Service;

import com.bootcamp.SocialMeli.DTO.*;
import com.bootcamp.SocialMeli.Exception.InvalidSocialException;
import com.bootcamp.SocialMeli.Exception.NotFoundException;
import com.bootcamp.SocialMeli.Mapper.SocialMapper;
import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import com.bootcamp.SocialMeli.Repository.ISocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SocialService implements ISocialService {

    @Autowired
    ISocialRepository iSocialRepository;


    @Override
    public SeguidorDTO postSeguidor(Seguidor seguidor) {
        if(iSocialRepository.getUsuario(seguidor.getIdUser()) ==null){
            throw new NotFoundException("No se encuentra el usuario: "+seguidor.getIdUser());
        }
        if(iSocialRepository.getUsuario(seguidor.getIdUserFollow()) ==null){
            throw new NotFoundException("No se encuentra el usuario a seguir: "+seguidor.getIdUserFollow());
        }
        if(iSocialRepository.getExisteSeguidorById(seguidor.getIdUser(),seguidor.getIdUserFollow()) != false){
            throw new InvalidSocialException("El usuario "+seguidor.getIdUser()+" ya sigue al vendedor "+seguidor.getIdUserFollow());
        }
        if(seguidor.getIdUser() == seguidor.getIdUserFollow()){
            throw new InvalidSocialException("No se puede seguir a si mismo!");
        }

        iSocialRepository.Follow(new Seguidor(seguidor.getIdUser(),seguidor.getIdUserFollow()));

        return new SeguidorDTO(iSocialRepository.getUsuario(seguidor.getIdUser()).getUserName(),seguidor.getIdUser(), iSocialRepository.getUsuario(seguidor.getIdUserFollow()).getUserName(),seguidor.getIdUserFollow());

    }

    @Override
    public SeguidoresCountDTO getSequidores(Integer idUser) {
        if(iSocialRepository.getUsuario(idUser) ==null){
            throw new NotFoundException("No se encuentra el usuario: "+idUser);
        }
        int cantidad = (int) iSocialRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUserFollow()==idUser).count();
        Usuario user = iSocialRepository.getUsuario(idUser);

        return new SeguidoresCountDTO(user.getUserId(),user.getUserName(), cantidad);
    }

    @Override
    public SeguidoresDTO getFollowers(Integer idUser) {
        if(iSocialRepository.getUsuario(idUser) == null){
            throw new NotFoundException("No se encuentra el usuario: "+idUser);
        }

        List<UsuarioDTO> usuarioDTO = new ArrayList<>();

        iSocialRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUserFollow()==idUser).forEach(
                usuario ->{
                    usuarioDTO.add(SocialMapper.UsuarioToUsuarioDTO( iSocialRepository.getUsuario(usuario.getIdUser())));
                }
        );
        Usuario usuario = iSocialRepository.getUsuario(idUser);

        return new SeguidoresDTO(usuario.getUserId(),usuario.getUserName(),usuarioDTO);
    }

    @Override
    public SeguidoresDTO getFollowed(Integer idUser) {
        if(iSocialRepository.getUsuario(idUser) == null){
            throw new NotFoundException("No se encuentra el usuario: "+idUser);
        }

        List<UsuarioDTO> usuarioDTO = new ArrayList<>();

        iSocialRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUser()==idUser).forEach(
                usuario ->{
                    usuarioDTO.add(SocialMapper.UsuarioToUsuarioDTO( iSocialRepository.getUsuario(usuario.getIdUserFollow())));
                }
        );
        UsuarioDTO user = SocialMapper.UsuarioToUsuarioDTO( iSocialRepository.getUsuario(idUser));

        return new SeguidoresDTO(user.getUserId(),user.getUserName(),usuarioDTO);
    }

    @Override
    public SeguidorDTO unFollow(Seguidor seguidor) {
        if(iSocialRepository.getUsuario(seguidor.getIdUser()) ==null){
            throw new NotFoundException("Seguidor no encontrado: "+seguidor.getIdUser());
        }
        if(iSocialRepository.getUsuario(seguidor.getIdUserFollow()) ==null){
            throw new NotFoundException("Usuario seguido no encontrado: "+seguidor.getIdUserFollow());
        }

        if(iSocialRepository.getExisteSeguidorById(seguidor.getIdUser(),seguidor.getIdUserFollow()) != true){
            throw new InvalidSocialException("El usuario "+seguidor.getIdUser()+" no sigue al vendedor "+seguidor.getIdUserFollow());
        }
        if(seguidor.getIdUser() == seguidor.getIdUserFollow()){
            throw new InvalidSocialException("No se puede dejar de seguir a si mismo!");
        }

        iSocialRepository.unFollow(seguidor);

        return null;
    }

    @Override
    public SeguidoresDTO getOrderFollow(Integer id, String order) {
        if(iSocialRepository.getUsuario(id) ==null){
            throw new NotFoundException("Usuario no encontrado: "+id);
        }

        SeguidoresDTO followers = getFollowers(id);

        List<UsuarioDTO> orderUsuario;
        if(order.equals("name_asc")){
            orderUsuario= followers.getFollowers().stream().sorted(Comparator.comparing(UsuarioDTO::getUserName)).collect(Collectors.toList());
        }else{
            orderUsuario= followers.getFollowers().stream().sorted(Comparator.comparing(UsuarioDTO::getUserName).reversed()).collect(Collectors.toList());
        }
        followers.setFollowers(orderUsuario);

        return followers;
    }

    @Override
    public SeguidoresDTO getOrderFollowed(Integer id, String order) {
        if(iSocialRepository.getUsuario(id) ==null){
            throw new NotFoundException("Usuario no encontrado: "+id);
        }

        SeguidoresDTO followers = getFollowed(id);

        List<UsuarioDTO> orderUsuario1;
        if(order.equals("name_asc")){
            orderUsuario1= followers.getFollowers().stream().sorted(Comparator.comparing(UsuarioDTO::getUserName)).collect(Collectors.toList());
        }else{
            orderUsuario1= followers.getFollowers().stream().sorted(Comparator.comparing(UsuarioDTO::getUserName).reversed()).collect(Collectors.toList());
        }
        followers.setFollowers(orderUsuario1);

        return followers;
    }

    @Override
    public PublicacionDTO setPublicacion(PublicacionDTO publica) {
        Publicacion publicacion = SocialMapper.PublicDTOaPublic(publica);

        if(iSocialRepository.getUsuario(publica.getUserId())==null){
            throw new InvalidSocialException("Usuario no encontrado: "+publica.getUserId());
        }

        if(iSocialRepository.getExisteSPostById(publica.getUserId(), publica.getIdPost()) != false){
            throw new InvalidSocialException("Ya existe el post con id: "+publica.getIdPost());
        }


        iSocialRepository.setPublicacion(publicacion);
        return null;
    }

    @Override
    public PublicUserDTO getPublicacionesRecientes(Integer userId, String order) {
        List<PublicacionDTO> traeList = getPublicacion(userId);
        List<PublicacionDTO> posts = traeList.stream().sorted(Comparator.comparing(PublicacionDTO::getDate).reversed()).collect(Collectors.toList());

        return new PublicUserDTO(userId,posts.stream().filter(publicacionDTO1 -> (int) ChronoUnit.DAYS.between(publicacionDTO1.getDate(),LocalDate.now())<=14).collect(Collectors.toList()));
    }
    @Override
    public PublicUserDTO getPubliOrderByFecha(Integer userId, String order) {
        List<PublicacionDTO> traeList = getPublicacion(userId);
        List<PublicacionDTO> posts;
        if(order.equals("date_asc")){
            posts = traeList.stream().sorted(Comparator.comparing(PublicacionDTO::getDate)).collect(Collectors.toList());
        }else{
            posts = traeList.stream().sorted(Comparator.comparing(PublicacionDTO::getDate).reversed()).collect(Collectors.toList());
        }

        return new PublicUserDTO(userId,posts);
    }
    @Override
    public List getPublicacion(Integer userId){
        if(iSocialRepository.getUsuario(userId) ==null){
            throw new NotFoundException("Usuario no encontrado: "+userId);
        }
        List<Integer> usersFollow = new ArrayList<>();
        iSocialRepository.getSeguidor().stream().filter(seguidor -> seguidor.getIdUser()==userId).forEach(
                user ->{
                    usersFollow.add(iSocialRepository.getUsuario(user.getIdUserFollow()).getUserId());
                }
        );
        List<PublicacionDTO> publicacion = new ArrayList<>();
        usersFollow.forEach(
                users ->{
                    if(iSocialRepository.getPublicaciones(users).size()>0){
                        iSocialRepository.getPublicaciones(users).forEach(user -> publicacion.add(SocialMapper.PublicacionTOPublicacionDTO( iSocialRepository.getPublicacion(user.getIdPost()))));
                    }
                }
        );
        return publicacion;
    }

    @Override
    public PromoPDTO setPromoPublicacion(PromoPDTO promopDTO) {
        return null;
    }

    @Override
    public PromoPubliCountDTO getPromoPubliCount(Integer id) {
        return null;
    }

    @Override
    public PromoPublicacionesDTO getPromoPublicaciones(Integer id) {
        return null;
    }


}
