package com.bootcamp.SocialMeli.service.usuario;

import com.bootcamp.SocialMeli.dto.usuario.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.usuario.FollowerListDTO;

public interface IUsuarioService {
    public void realizarFollow(Integer userId, Integer userIdToFollow);

    public FollowerCountDTO cantidadFollowers(Integer userId);

    public FollowerListDTO listaFollowers(Integer userId);

    public FollowedListDTO listaFollowed(Integer userId);
}
