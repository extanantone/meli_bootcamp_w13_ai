package com.bootcamp.SocialMeli.repository.publicacion;

import com.bootcamp.SocialMeli.model.Publicacion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PublicacionRepository implements IPublicacionRepository {
    List<Publicacion> listaPublicaciones;

    public PublicacionRepository() {
        this.listaPublicaciones = new ArrayList<>();
    }

    public List<Publicacion> abrirPublicacionJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:publicacion.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Publicacion>> typeRef = new TypeReference<>() {
        };
        List<Publicacion> listaPublicaciones = null;
        try {
            listaPublicaciones = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPublicaciones;
    }

    @Override
    public void insertarPublicacion(Publicacion publicacion) {
        listaPublicaciones.add(publicacion);
    }

    @Override
    public Publicacion devolverPublicacion(Integer idPost) {
        return this.listaPublicaciones
                .stream()
                .filter(publicacion -> publicacion.getIdPost() == idPost)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Publicacion> devolverPublicaciones(Integer userId) {
        return this.listaPublicaciones
                .stream()
                .filter(publicacion -> publicacion.getUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public void insertarPublicacionPromo(Publicacion publicacion) {
        listaPublicaciones.add(publicacion);
    }

}
