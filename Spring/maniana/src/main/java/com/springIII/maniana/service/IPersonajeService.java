package com.springIII.maniana.service;

import com.springIII.maniana.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonajes(String nombre);
}
