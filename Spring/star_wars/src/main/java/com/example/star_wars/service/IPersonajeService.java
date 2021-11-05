package com.example.star_wars.service;

import com.example.star_wars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
