package com.c3.p1.service;

import com.c3.p1.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> buscarPersonaje(String name);
}
