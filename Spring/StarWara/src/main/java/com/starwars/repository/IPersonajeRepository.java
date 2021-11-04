package com.starwars.repository;

import com.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getPersonajesByName(String name);
}
