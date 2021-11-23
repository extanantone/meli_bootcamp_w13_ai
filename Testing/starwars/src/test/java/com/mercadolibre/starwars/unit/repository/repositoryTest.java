package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class repositoryTest {
    CharacterRepositoryImpl repository = new CharacterRepositoryImpl() ;
    @Test
    void findAllByNameContainsLuke(){
        // Arrange
        String query = "luke";

        // Act
        List<CharacterDTO> current = repository.findAllByNameContains(query);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human",172,77));

        // Assert
        Assertions.assertEquals(expected, current);
    }
    @Test
    void findAllByNameContainsDarthSize(){
        // Arrange
        String query = "darth";

        // Act
        List<CharacterDTO> current = repository.findAllByNameContains(query);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human",172,77));

        // Assert
        Assertions.assertEquals(2,current.size());
    }

}
