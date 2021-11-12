package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowerCountDTO;
import com.bootcamp.SocialMeli.dto.FollowerListDTO;

import java.util.List;

public interface IUsuarioService {
    public void realizarFollow(Integer userId, Integer userIdToFollow);

    public FollowerCountDTO cantidadFollowers(Integer userId);

    public FollowerListDTO listaFollowers(Integer userId);

    public FollowedListDTO listaFollowed(Integer userId);
}
