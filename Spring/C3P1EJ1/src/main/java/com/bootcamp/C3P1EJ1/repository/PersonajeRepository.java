package com.bootcamp.C3P1EJ1.repository;


import com.bootcamp.C3P1EJ1.model.Personaje;
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
public class PersonajeRepository implements PersonajeRepositoryInterfaz {

    List<Personaje> listaPersonajes; //PERSONAJE

    PersonajeRepository() {
        this.listaPersonajes = abrirPersonajeJSON();
    }

    protected List<Personaje> abrirPersonajeJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json"); //obtiene el recurso, que viene a ser el archivo guardado en la classpath que se pasa
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper(); //mapea lo que está en el archivo al objeto, en este caso al objeto personaje.
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() { //acá referencia a la lista de personaje
        };
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef); //leer el valor del archivo a través del typeRef
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }


    @Override
    public List<Personaje> buscarPersonajes(String name) {
        return this.listaPersonajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
