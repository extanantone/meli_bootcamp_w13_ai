package com.company.StarWars.service;

import com.company.StarWars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> getCharactersByName(String name);
}
