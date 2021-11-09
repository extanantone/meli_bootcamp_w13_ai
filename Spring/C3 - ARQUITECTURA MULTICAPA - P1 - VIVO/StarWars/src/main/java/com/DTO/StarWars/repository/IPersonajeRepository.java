package com.DTO.StarWars.repository;

import com.DTO.StarWars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> findByName(String name);
}
