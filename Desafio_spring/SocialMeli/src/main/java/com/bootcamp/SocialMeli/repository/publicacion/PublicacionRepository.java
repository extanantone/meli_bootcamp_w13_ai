package com.bootcamp.SocialMeli.repository.publicacion;

import com.bootcamp.SocialMeli.model.Publicacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PublicacionRepository implements IPublicacionRepository {
    List<Publicacion> listaPublicaciones;

    public PublicacionRepository() {
        this.listaPublicaciones = new ArrayList<>();
    }

    @Override
    public void insertarPublicacion(Publicacion publicacion) {
        listaPublicaciones.add(publicacion);
    }

    @Override
    public Publicacion devolverPublicacion(Integer idPost) {
        return this.listaPublicaciones
                .stream()
                .filter(publicacion -> publicacion.getIdPost().equals(idPost))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Publicacion> devolverPublicaciones(Integer userId) {
        return this.listaPublicaciones
                .stream()
                .filter(publicacion -> publicacion.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void insertarPublicacionPromo(Publicacion publicacion) {
        listaPublicaciones.add(publicacion);
    }

}
