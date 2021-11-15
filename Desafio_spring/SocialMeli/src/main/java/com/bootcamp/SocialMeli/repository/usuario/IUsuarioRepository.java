package com.bootcamp.SocialMeli.repository.usuario;

import com.bootcamp.SocialMeli.model.Usuario;

public interface IUsuarioRepository {

    public void insertarFollower(Integer userId, Integer userIdToFollow);

    public void insertarFollowed(Integer userId, Integer userIdToFollow);

    public Usuario devolverUsuario(Integer userId);

    public boolean encontrarUsuario(Integer userId);

    public void eliminarFollower(Integer userId, Integer userIdToFollow);

    public void eliminarFollowed(Integer userId, Integer userIdToFollow);

}
