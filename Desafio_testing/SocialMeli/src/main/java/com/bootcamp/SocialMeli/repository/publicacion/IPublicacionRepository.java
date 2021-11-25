package com.bootcamp.SocialMeli.repository.publicacion;

import com.bootcamp.SocialMeli.model.Publicacion;

import java.util.List;

public interface IPublicacionRepository {
    void insertarPublicacion(Publicacion publicacion);

    Publicacion devolverPublicacion(Integer idPost);

    List<Publicacion> devolverPublicaciones(Integer userId);

    void insertarPublicacionPromo(Publicacion publicacion);
}
