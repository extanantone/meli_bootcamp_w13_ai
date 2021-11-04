package com.ejercicio.demo.service;

import com.ejercicio.demo.dto.CharacterDTO;

import java.util.List;

public interface IStarWarsService {

    List<CharacterDTO> getCharacterService(String name);
}
