package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CharacterRespositoryImplTest {

    CharacterRepositoryImpl repo = new CharacterRepositoryImpl();

    @Test
        //@DisplayName("Nuevo nombre del test")
    void withStringNameValidThenFindAllByNameContains(){
        // Arrange
        String name = "Luke";
        CharacterDTO l1 = new CharacterDTO();
        l1.setName("Luke Skywalker");
        l1.setHeight(172);
        l1.setMass(77);
        l1.setHair_color("blond");
        l1.setSkin_color("fair");
        l1.setEye_color("blue");
        l1.setBirth_year("19BBY");
        l1.setGender("male");
        l1.setHomeworld("Tatooine");
        l1.setSpecies("Human");
        List<CharacterDTO> expected = new LinkedList<>();
        expected.add(l1);

        // Act
        List<CharacterDTO> current = repo.findAllByNameContains(name);

        // Assert

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, current),
                () -> Assertions.assertEquals(current.size(), 1)
        );
    }

    @Test
    void NotFound(){
        // Arrange
        String name = "NOT FOUND";

        // Act
        List<CharacterDTO> current = repo.findAllByNameContains(name);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(current.isEmpty()),
                () -> Assertions.assertEquals(current.size(), 0)
        );
        ;
    }
}
