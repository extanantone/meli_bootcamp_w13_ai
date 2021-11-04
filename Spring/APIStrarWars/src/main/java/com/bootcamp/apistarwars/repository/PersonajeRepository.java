package com.bootcamp.apistarwars.repository;

import com.bootcamp.apistarwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    private List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = abrirPersonajeJSON();
    }

    protected List<Personaje> abrirPersonajeJSON(){

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
        return this.personajes.stream()
                .filter(personaje -> personaje.getName()
                        .toLowerCase()
                        .contains(nombre))
                        .collect(Collectors.toList());
    }
}
