package com.ejpractico.personajestarwars.service;

import com.ejpractico.personajestarwars.dto.PersonajeDTO;

import java.util.List;
public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
