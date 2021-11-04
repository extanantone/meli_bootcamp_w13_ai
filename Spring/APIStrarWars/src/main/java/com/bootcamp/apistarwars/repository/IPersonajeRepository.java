package com.bootcamp.apistarwars.repository;

import com.bootcamp.apistarwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> buscarPersonajes(String nombre);

}
