package com.company.StarWars.service;

import com.company.StarWars.dto.CharacterDTO;
import com.company.StarWars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    CharacterRepository repository;

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        return this.repository.getCharactersByName(name);
    }
}
