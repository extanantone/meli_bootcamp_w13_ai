package com.DTO.StarWars.service;

import com.DTO.StarWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getPersonajeByName(String name);
}
