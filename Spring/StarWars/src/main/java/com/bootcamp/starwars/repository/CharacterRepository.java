package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Repository
public class CharacterRepository implements ICharacterRepository {

    List<Character> characters;

    public CharacterRepository() {
        this.characters = openCharactersJson();
    }

    protected List<Character> openCharactersJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<Character> getCharactersByName(String name) {
        return this.characters;
    }
}
