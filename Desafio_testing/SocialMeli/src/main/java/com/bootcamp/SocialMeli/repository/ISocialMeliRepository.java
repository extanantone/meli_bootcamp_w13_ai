package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;

public interface ISocialMeliRepository {
    Usuario buscarUsuario(Integer idUsuario);
    Publicacion buscarPublicacion(Integer idPublicacion);
    void agregarPublicacion(Publicacion publicacion);
    void agregarUsuario(Usuario usuario);
}
