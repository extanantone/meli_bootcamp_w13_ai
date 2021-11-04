package com.springIII.maniana.repository;

import com.springIII.maniana.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String nombre);
}
