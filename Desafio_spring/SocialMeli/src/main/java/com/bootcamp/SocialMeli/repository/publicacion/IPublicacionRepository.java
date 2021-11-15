package com.bootcamp.SocialMeli.repository.publicacion;

import com.bootcamp.SocialMeli.model.Publicacion;

import java.util.List;

public interface IPublicacionRepository {
    public void insertarPublicacion(Publicacion publicacion);

    public Publicacion devolverPublicacion(Integer idPost);

    public List<Publicacion> devolverPublicaciones(Integer userId);

    public void insertarPublicacionPromo(Publicacion publicacion);
}
