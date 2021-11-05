package com.example.star_wars.repository;

import com.example.star_wars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String nombre);
}
