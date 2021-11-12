package com.bootcamp.SocialMeli.repository.usuario;

import com.bootcamp.SocialMeli.model.Usuario;

import java.util.List;

public interface IUsuarioRepository {

    public void insertarFollower(Integer userId, Integer userIdToFollow);

    public void insertarFollowed(Integer userId, Integer userIdToFollow);

    public Usuario devolverUsuario(Integer userId);

}
