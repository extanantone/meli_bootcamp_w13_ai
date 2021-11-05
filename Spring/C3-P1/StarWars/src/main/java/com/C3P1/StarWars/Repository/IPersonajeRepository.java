package com.C3P1.StarWars.Repository;

import com.C3P1.StarWars.Model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String nombre);
}
