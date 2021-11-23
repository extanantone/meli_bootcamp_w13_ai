package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class CharacterRepositoryTest {
    CharacterRepositoryImpl characterRepository= new CharacterRepositoryImpl();

    @Test
    void findCharacterByName(){
        // Arrange
        String characterName= "mas";
        CharacterDTO expected= new CharacterDTO();
        expected.setName(characterName);

        //Act
        List<CharacterDTO> current= characterRepository.
                findAllByNameContains(expected.getName());

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(
                        current.get(0)
                                .getName().toUpperCase()
                                .contains(characterName.toUpperCase())
                )
        );
    }

    @Test
    void finIfCharacterNotExist(){
        // Arrange
        String characterName= "pas";
        CharacterDTO expected= new CharacterDTO();
        expected.setName(characterName);

        //Act
        List<CharacterDTO> current= characterRepository.
                findAllByNameContains(expected.getName());

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        current.size(), 0
                )
        );
    }

}
