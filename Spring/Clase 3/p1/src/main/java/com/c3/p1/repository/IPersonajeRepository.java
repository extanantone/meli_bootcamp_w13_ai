package com.c3.p1.repository;

import com.c3.p1.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String name);
}
