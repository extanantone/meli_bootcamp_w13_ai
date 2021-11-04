package com.example.demo.repository;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.models.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class RepositoryPersonajeImpl implements IRepositoryPersonaje{
    List<Personaje> listaPersonajes;

    public RepositoryPersonajeImpl(List<Personaje> listaPersonajes) {
        this.listaPersonajes = abrirPersonajesJson();
    }

    protected List<Personaje> abrirPersonajesJson(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;

    }

    @Override
    public List<Personaje> buscarPersonajes(String nombre) {
        return listaPersonajes;
    }
}
