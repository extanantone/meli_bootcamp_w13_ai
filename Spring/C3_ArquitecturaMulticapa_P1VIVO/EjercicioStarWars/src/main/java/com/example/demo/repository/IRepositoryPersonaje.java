package com.example.demo.repository;

import com.example.demo.models.Personaje;

import java.util.List;

public interface IRepositoryPersonaje {
    List<Personaje> buscarPersonajes(String nombre);
}
