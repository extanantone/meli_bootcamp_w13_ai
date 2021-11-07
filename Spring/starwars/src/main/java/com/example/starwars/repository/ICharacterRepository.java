package com.example.starwars.repository;

import java.util.List;
import com.example.starwars.model.Character;

public interface ICharacterRepository {
    List<Character> retrieveCharacters (String letters);
}
