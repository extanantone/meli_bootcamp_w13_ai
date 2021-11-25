package com.bootcamp.SocialMeli.repository.usuario;

import com.bootcamp.SocialMeli.model.Usuario;

public interface IUsuarioRepository {

    void insertarFollower(Integer userId, Integer userIdToFollow);

    void insertarFollowed(Integer userId, Integer userIdToFollow);

    Usuario devolverUsuario(Integer userId);

    boolean encontrarUsuario(Integer userId);

    void eliminarFollower(Integer userId, Integer userIdToFollow);

    void eliminarFollowed(Integer userId, Integer userIdToFollow);

}
