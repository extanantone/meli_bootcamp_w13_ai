package com.DTO.StarWars.repository;

import com.DTO.StarWars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{
    List<Personaje> personajes;

    PersonajeRepository() {
        this.personajes = abrirPersonajesJson();
    }

    protected List<Personaje> abrirPersonajesJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public List<Personaje> findByName(String name) {
        return this.personajes.stream().filter(p->p.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
