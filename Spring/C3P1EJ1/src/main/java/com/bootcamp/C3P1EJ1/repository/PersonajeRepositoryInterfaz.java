package com.bootcamp.C3P1EJ1.repository;

import com.bootcamp.C3P1EJ1.model.Personaje;

import java.util.List;

public interface PersonajeRepositoryInterfaz {
    List<Personaje> buscarPersonajes(String name); //PERSONAJE
}
