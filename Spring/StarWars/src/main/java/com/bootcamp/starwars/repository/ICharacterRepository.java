package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Character;

import java.util.List;

public interface ICharacterRepository {

    List<Character> getCharactersByName(String name);
}
