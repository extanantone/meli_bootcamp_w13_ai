package com.c3spring.ejercicio.repository;

import com.c3spring.ejercicio.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPersonajes implements IObtenerData {

    List<Personaje> listaPersonajes = new ArrayList<>();

    RepositorioPersonajes(){
        this.listaPersonajes = leerArchivo();
    }

    protected List<Personaje> leerArchivo(){
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:personajes.json");
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

    // se emula que la consulta se hace en el repositorio o base de datos, atraves del orm o consultas sql
    @Override
    public List<Personaje> obtenerOrigenDatos(String nombre) {
        return this.listaPersonajes;
    }


}
