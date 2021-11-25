package com.bootcamp.SocialMeli.service.usuario;

import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerListDTO;

public interface IUsuarioService {
    void realizarFollow(Integer userId, Integer userIdToFollow);

    FollowerCountDTO cantidadFollowers(Integer userId);

    FollowerListDTO listaFollowers(Integer userId, String order);

    FollowedListDTO listaFollowed(Integer userId, String order);

    void realizarUnfollow(Integer userId, Integer userIdToFollow);


}
