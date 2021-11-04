package com.c3.p1.repository;

import com.c3.p1.dto.PersonajeDto;
import com.c3.p1.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{
    List<Personaje> personajes;

    public PersonajeRepository(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            personajes = new ArrayList<>();
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> buscarPersonajes(String name) {
        return personajes.stream().filter(c -> c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }
}
