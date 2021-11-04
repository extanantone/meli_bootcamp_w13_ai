package com.ejercicio.demo.repository;

import com.ejercicio.demo.models.Character;
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
public class CharacterRepository implements ICharacterRepository{

    List<Character> characters;

    public CharacterRepository(){

        this.characters = openCharactersJSON();

    }

    private List<Character> openCharactersJSON() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
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
    public List<Character> findCharacter(String name) {
        return this.characters.stream()
                .filter(p -> p.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase()))
                            .collect(Collectors.toList());

    }
}
