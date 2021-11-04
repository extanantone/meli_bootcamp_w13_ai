package com.ejercicio.demo.repository;

import com.ejercicio.demo.models.Character;

import java.util.List;

public interface ICharacterRepository {

    List<Character> findCharacter(String name);
}
