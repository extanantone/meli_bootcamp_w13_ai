package com.ejpractico.personajestarwars.repository;

import com.ejpractico.personajestarwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String nombre);
}
