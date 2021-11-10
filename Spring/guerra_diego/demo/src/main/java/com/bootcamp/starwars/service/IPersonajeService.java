package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> obtenerPersonaje(String nombre);
}
