package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerListDTO;
import com.bootcamp.SocialMeli.dto.usuario.UsuarioDTO;
import com.bootcamp.SocialMeli.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public FollowerCountDTO usuarioAFollowerCountDTO(Usuario usuario) {
        FollowerCountDTO followerCountDTO = new FollowerCountDTO();
        followerCountDTO.setUserId(usuario.getUserId());
        followerCountDTO.setUserName(usuario.getUserName());
        followerCountDTO.setFollowersCount(usuario.getFollowers().size());
        return followerCountDTO;
    }

    public FollowerListDTO usuarioAFollowerListDTO(Usuario usuario) {
        FollowerListDTO followerListDTO = new FollowerListDTO();
        followerListDTO.setUserId(usuario.getUserId());
        followerListDTO.setUserName(usuario.getUserName());
        followerListDTO.setFollowers(usuario.getFollowers()
                .stream()
                .map(u -> new UsuarioDTO(u.getUserId(), u.getUserName()))
                .collect(Collectors.toList()));
        return followerListDTO;
    }

    public FollowedListDTO usuarioAFollowedListDTO(Usuario usuario) {
        FollowedListDTO followedListDTO = new FollowedListDTO();
        followedListDTO.setUserId(usuario.getUserId());
        followedListDTO.setUserName(usuario.getUserName());
        followedListDTO.setFollowed(usuario.getFollowed()
                .stream()
                .map(u -> new UsuarioDTO(u.getUserId(), u.getUserName()))
                .collect(Collectors.toList()));
        return followedListDTO;
    }
}
