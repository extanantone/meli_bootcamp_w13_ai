package com.bootcamp.SocialMeli.service.usuario;

import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerListDTO;
import com.bootcamp.SocialMeli.dto.usuario.UsuarioDTO;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.mapper.UsuarioMapper;
import com.bootcamp.SocialMeli.repository.usuario.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    IUsuarioRepository iUsuarioRepository;
    UsuarioMapper usuarioMapper;

    public UsuarioService(IUsuarioRepository iUsuarioRepository, UsuarioMapper usuarioMapper) {
        this.iUsuarioRepository = iUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public void controlExistenciaUsuario(Integer userId) {
        if (!iUsuarioRepository.encontrarUsuario(userId)) {
            throw new BadRequestException("El usuario con ID " + userId + " no existe.");
        }
    }

    @Override
    public void realizarFollow(Integer userId, Integer userIdToFollow) throws BadRequestException {
        controlExistenciaUsuario(userId);
        controlExistenciaUsuario(userIdToFollow);
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("Los usuarios no se pueden seguir a sí mismos.");
        }
        if (iUsuarioRepository
                .devolverUsuario(userId)
                .getFollowed()
                .contains(iUsuarioRepository.devolverUsuario(userIdToFollow))) {
            throw new BadRequestException("El usuario con ID " + userId + " ya sigue al usuario con ID " + userIdToFollow + ".");
        }
        iUsuarioRepository.insertarFollowed(userId, userIdToFollow);
        iUsuarioRepository.insertarFollower(userId, userIdToFollow);
    }

    @Override
    public FollowerCountDTO cantidadFollowers(Integer userId) {
        controlExistenciaUsuario(userId);
        FollowerCountDTO followerCountDTO = usuarioMapper.usuarioAFollowerCountDTO(iUsuarioRepository.devolverUsuario(userId));
        if (followerCountDTO.getFollowersCount() == 0) {
            throw new BadRequestException("El usuario con ID " + userId + " no tiene ningún follower.");
        }
        return followerCountDTO;
    }

    @Override
    public FollowerListDTO listaFollowers(Integer userId, String order) {
        controlExistenciaUsuario(userId);
        FollowerListDTO followerListDTO = usuarioMapper.usuarioAFollowerListDTO(iUsuarioRepository.devolverUsuario(userId));
        if (followerListDTO.getFollowers().size() == 0) {
            throw new BadRequestException("El usuario con ID " + userId + " no tiene followers.");
        }
        if (order.equals("name_asc")) {
            followerListDTO.setFollowers(followerListDTO.getFollowers()
                    .stream()
                    .sorted(Comparator.comparing(UsuarioDTO::getUserName))
                    .collect(Collectors.toList()));
        } else if (order.equals("name_desc")) {
            followerListDTO.setFollowers(followerListDTO.getFollowers()
                    .stream()
                    .sorted(Comparator.comparing(UsuarioDTO::getUserName)
                            .reversed())
                    .collect(Collectors.toList()));
        }
        return followerListDTO;
    }

    @Override
    public FollowedListDTO listaFollowed(Integer userId, String order) {
        controlExistenciaUsuario(userId);
        FollowedListDTO followedListDTO = usuarioMapper.usuarioAFollowedListDTO(iUsuarioRepository.devolverUsuario(userId));
        if (followedListDTO.getFollowed().size() == 0) {
            throw new BadRequestException("El usuario con ID " + userId + " no tiene followed.");
        }
        if (order.equals("name_asc")) {
            followedListDTO.setFollowed(followedListDTO.getFollowed()
                    .stream()
                    .sorted(Comparator.comparing(UsuarioDTO::getUserName))
                    .collect(Collectors.toList()));
        } else if (order.equals("name_desc")) {
            followedListDTO.setFollowed(followedListDTO.getFollowed()
                    .stream()
                    .sorted(Comparator.comparing(UsuarioDTO::getUserName)
                            .reversed())
                    .collect(Collectors.toList()));
        }
        return followedListDTO;
    }

    @Override
    public void realizarUnfollow(Integer userId, Integer userIdToFollow) {
        controlExistenciaUsuario(userId);
        controlExistenciaUsuario(userIdToFollow);
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("El usuario con ID " + userId + " no se puede dejar de seguir a sí mismo.");
        }
        if (!iUsuarioRepository
                .devolverUsuario(userId)
                .getFollowed()
                .contains(iUsuarioRepository.devolverUsuario(userIdToFollow))) {
            throw new BadRequestException("El usuario con ID " + userId + " no está siguiendo al usuario con ID " + userIdToFollow + ".");
        }
        iUsuarioRepository.eliminarFollower(userId, userIdToFollow);
        iUsuarioRepository.eliminarFollowed(userId, userIdToFollow);
    }

}
