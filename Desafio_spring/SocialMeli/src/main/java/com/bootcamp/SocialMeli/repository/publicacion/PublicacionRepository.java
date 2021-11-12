package com.bootcamp.SocialMeli.repository.publicacion;

import com.bootcamp.SocialMeli.model.Publicacion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PublicacionRepository implements IPublicacionRepository {
    List<Publicacion> listaPublicaciones;

    public PublicacionRepository() {
        this.listaPublicaciones = abrirPublicacionJSON();
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

    }

}
