package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CharacterRepositoryImplTest {

    private CharacterRepositoryImpl repo = new CharacterRepositoryImpl();

    @Test
    @DisplayName("Buscar personaje inexistente test")
    void noCharactersFoundTest(){
        //Arrange
        String query = "dfsalkmfglsm";

        //Act
        List<CharacterDTO> response = repo.findAllByNameContains(query);

        //Assert
        Assertions.assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("Buscar todos los personajes existentes por nombre")
    void findAllCharactersTest(){
        //Arrange
        List<CharacterDTO> awaitedCharacters;
        String query = "Darth";
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        c1.setName("Darth Vader");
        c2.setName("Darth Maul");
        awaitedCharacters = Arrays.asList(c1, c2);

        //Act
        List<CharacterDTO> response = repo.findAllByNameContains(query);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(awaitedCharacters.size(), response.size()),
                () -> Assertions.assertEquals(awaitedCharacters.get(0).getName(), response.get(0).getName()),
                () -> Assertions.assertEquals(awaitedCharacters.get(1).getName(), response.get(1).getName())
        );
    }

}
