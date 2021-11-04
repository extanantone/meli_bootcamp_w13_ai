package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonajes(String nombre);
}
