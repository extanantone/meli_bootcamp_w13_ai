package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;
import com.example.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{

    ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharacters(String letters) {
        List<Character> characters = this.characterRepository.retrieveCharacters(letters);

        return characters.stream().map(CharacterDTO::new).collect(Collectors.toList());
    }
}
