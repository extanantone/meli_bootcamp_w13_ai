package com.C3P1.StarWars.Service;

import com.C3P1.StarWars.DTO.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
