package com.bootcamp.StarWars.Repository;

import com.bootcamp.StarWars.Model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String nombre);
}
