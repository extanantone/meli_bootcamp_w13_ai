package com.ejercicio.demo.service;

import com.ejercicio.demo.dto.CharacterDTO;
import com.ejercicio.demo.models.Character;
import com.ejercicio.demo.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //@Service va en la interfaz, no en la implementacion
public class StarWarsService implements IStarWarsService{

    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getCharacterService(String name) {

        List<Character> characters = this.characterRepository.findCharacter(name);

        return characters.stream()
                .map(p -> new CharacterDTO(p))
                .collect(Collectors.toList());

    }



}
