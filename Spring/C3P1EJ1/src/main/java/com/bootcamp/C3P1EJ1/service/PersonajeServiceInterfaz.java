package com.bootcamp.C3P1EJ1.service;

import com.bootcamp.C3P1EJ1.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeServiceInterfaz {
    List<PersonajeDTO> obtenerPersonaje(String name); //PERSONAJE DTO
}
