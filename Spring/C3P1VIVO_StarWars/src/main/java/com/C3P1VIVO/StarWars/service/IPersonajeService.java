package com.C3P1VIVO.StarWars.service;

import com.C3P1VIVO.StarWars.dto.PersonajeDTO;

import java.util.List;


public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
