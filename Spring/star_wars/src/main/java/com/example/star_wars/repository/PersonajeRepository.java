package com.example.star_wars.repository;

import com.example.star_wars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonajeRepository implements  IPersonajeRepository{
    List<Personaje> personajes;

    PersonajeRepository(){
//        this.personajes =
    }


    @Override
    public List<Personaje> buscarPersonajes(String nombre) {
        return null;
    }
}
