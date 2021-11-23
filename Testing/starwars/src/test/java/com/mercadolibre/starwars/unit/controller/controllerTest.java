package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class controllerTest {
    FindController controller = new FindController();
    @Test
    void find(){
        // Arrange
        String query = "luke";

        // Act
        List<CharacterDTO>  current = controller.find(query);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human",172,77));

        // Assert
        Assertions.assertEquals(expected,current);
    }
}
