package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {

    CharacterRepository repo = new CharacterRepositoryImpl();

    @Test
    @DisplayName("When find characters include name Luke")
    void test1() {


        // Arrange
            String name = "Luke";
            CharacterDTO character = new CharacterDTO();
            character.setName("Luke Skywalker");


            List<CharacterDTO> expected = List.of(character);
        // Act
            List<CharacterDTO>  current = repo.findAllByNameContains(name);
        //Assert
        Assertions.assertEquals(expected.get(0).getName(),current.get(0).getName());
        Assertions.assertEquals(current.size(),1);

    }

    @Test
    @DisplayName("When find characters include name Darth")
    void test2() {


        // Arrange
        String name = "Darth";
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Darth Vader");

        CharacterDTO character2 = new CharacterDTO();

        character2.setName("Darth Maul");

        List<CharacterDTO> expected = List.of(character1,character2);
        // Act
        List<CharacterDTO>  current = repo.findAllByNameContains(name);
        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.get(0).getName(),current.get(0).getName()),
                () -> Assertions.assertEquals(expected.get(1).getName(),current.get(1).getName()),
                () -> Assertions.assertEquals(current.size(),2)
        );

    }

    @Test
    @DisplayName("When find characters didn't match query")
    void test3() {
        // Arrange
            String name = "Not Found";
        // Act
            List<CharacterDTO>  current = repo.findAllByNameContains(name);
        // Assert
        Assertions.assertTrue(current.isEmpty());

    }
}
