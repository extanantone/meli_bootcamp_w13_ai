package com.bootcamp.Clase3.repository;

import com.bootcamp.Clase3.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    List<Personaje> personajes;



    @Override
    public List<Personaje> buscarPersonajes(String nombre) {
        return null;
    }
}
