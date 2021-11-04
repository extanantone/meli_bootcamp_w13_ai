package com.example.bootcamp.StarWarsApi.repository;

import com.example.bootcamp.StarWarsApi.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    public List<Personaje> buscarPersonajes(String nombre);

}
