package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.model.Character;
import com.bootcamp.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        List<Character> characters = characterRepository.getCharacters();
        return characters.stream()
                .map(CharacterDTO::new)
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
