package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest
{

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContainsFoundMatch()
    {
        //Arrange
        String charName = "Luke";
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        List<CharacterDTO> expected = List.of(luke);
        // Act
        List<CharacterDTO> current = characterRepository.findAllByNameContains(charName);
        // Assert
        Assertions.assertEquals(expected.get(0).getName(), current.get(0).getName());
    }

    @Test
    void findAllByNameContainsDoesNotFoundMatch()
    {
        //Arrange
        String charName = "NOT FOUND";
        // Act
        List<CharacterDTO> current = characterRepository.findAllByNameContains(charName);
        // Assert
        Assertions.assertTrue(current.isEmpty());
    }
}