package com.example.starwars.repository;

import com.example.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {

    List<Character> characters;

    CharacterRepository() {
        this.characters = readCharacters();
    }

    protected List<Character> readCharacters() {
        List<Character> characters = null;
        File file = null;
        ObjectMapper map = new ObjectMapper();
        TypeReference<List<Character>> reference = new TypeReference<>() {};

        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            characters = map.readValue(file, reference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<Character> retrieveCharacters(String letters) {
        return this.characters.stream().filter(p -> p.getName().toLowerCase().contains(letters.toLowerCase())).collect(Collectors.toList());
    }
}
