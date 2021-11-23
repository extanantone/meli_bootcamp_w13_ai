package com.starwars.service;

import com.starwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> getPersonajesByName(String name);
}
