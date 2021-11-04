package com.example.bootcamp.StarWarsApi.service;

import com.example.bootcamp.StarWarsApi.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> obtenerPersonajes(String nombre);

}
