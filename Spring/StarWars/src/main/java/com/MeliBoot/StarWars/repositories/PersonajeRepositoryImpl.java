package com.MeliBoot.StarWars.repositories;

import com.MeliBoot.StarWars.models.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{

    List<Personaje> baseDeDatosPersonajes;

    void PersonajeRepository(){
        this.baseDeDatosPersonajes = abrirPersonajesJSON();
    }

    List<Personaje> abrirPersonajesJSON() {
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
    public List<Personaje> getPersonajes() {
        return baseDeDatosPersonajes;
    }

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        return baseDeDatosPersonajes.stream().filter(x -> x.getName().contains(nombre)).collect(Collectors.toList());
    }
}
