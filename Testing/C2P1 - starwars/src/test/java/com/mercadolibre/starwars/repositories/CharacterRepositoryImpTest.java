package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class CharacterRepositoryImpTest {
    private final CharacterRepositoryImpl characterRepositoryImp = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains() {
        // Arrange
        String name = "Leia";
        CharacterDTO leia = new CharacterDTO();
        leia.setName("Leia Organa");
        List<CharacterDTO> expect = List.of(leia);

        // Act
        List<CharacterDTO> actual = characterRepositoryImp.findAllByNameContains(name);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(actual.get(0).getName(), expect.get(0).getName()),
                () -> Assertions.assertEquals(actual.size(), expect.size(), 1)
        );
    }

    @Test
    void NotFindAllByNameContains() {
        // Arrange
        String name = "NOT FOUND";

        // Act
        List<CharacterDTO> actual = characterRepositoryImp.findAllByNameContains(name);

        // Assert
        Assertions.assertTrue(actual.isEmpty());
    }
}
