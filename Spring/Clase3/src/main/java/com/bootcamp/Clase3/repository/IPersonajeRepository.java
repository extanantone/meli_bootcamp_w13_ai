package com.bootcamp.Clase3.repository;

import com.bootcamp.Clase3.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> buscarPersonajes(String nombre);


}
