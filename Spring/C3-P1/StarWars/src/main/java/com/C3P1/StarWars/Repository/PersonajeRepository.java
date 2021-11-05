package com.C3P1.StarWars.Repository;

import com.C3P1.StarWars.Model.Personaje;
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

    List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = abrirPersonajesJson();
    }

    private List<Personaje> abrirPersonajesJson(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    @Override
    public List<Personaje> buscarPersonajes(String nombre) {
        return this.personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
}
