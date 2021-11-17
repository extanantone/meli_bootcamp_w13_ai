package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.model.Vendedor;

import java.util.HashMap;
import java.util.Optional;

public interface PublicacionRepositoryImplement {
    Publicacion nuevaPublicacion(Publicacion pub);
    HashMap<Integer, Publicacion> findAll();
    Optional<Publicacion> find(Integer id);
}
