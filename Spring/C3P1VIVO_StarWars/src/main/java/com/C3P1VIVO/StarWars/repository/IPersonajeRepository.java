package com.C3P1VIVO.StarWars.repository;

import com.C3P1VIVO.StarWars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String nombre);
}
