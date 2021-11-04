package com.bootcamp.Clase3.service;

import com.bootcamp.Clase3.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String nombre);
}
