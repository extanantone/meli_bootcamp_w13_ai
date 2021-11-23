package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class serviceTest {
    CharacterRepositoryImpl repository = new CharacterRepositoryImpl() ;
    FindService service = new FindService(repository);

    @Test
    void findServiceTestLuke(){
        // Arrange
        String query = "luke";

        // Act
        List<CharacterDTO> current = service.find(query);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human",172,77));

        // Assert
        Assertions.assertEquals(expected, current);
    }
    @Test
    void findServiceTestVacio(){
        // Arrange
        String query = "sofia";

        // Act
        List<CharacterDTO> current = service.find(query);

        // Assert
        Assertions.assertTrue(current.isEmpty());
    }

}
