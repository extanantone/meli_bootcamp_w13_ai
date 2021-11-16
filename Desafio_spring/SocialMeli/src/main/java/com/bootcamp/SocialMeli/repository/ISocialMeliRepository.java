package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;

import java.util.List;

public interface ISocialMeliRepository {
    Usuario buscarUsuario(Integer idUsuario);
    Publicacion buscarPublicacion(Integer idPublicacion);
    void agregarPublicacion(Publicacion publicacion);

   // public List<Usuario> buscarSeguidores(Usuario vendedor);
}
