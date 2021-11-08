package com.company.StarWars.repository;

import com.company.StarWars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {

    List<CharacterDTO> getCharactersByName(String name);
}
