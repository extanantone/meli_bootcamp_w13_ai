package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest
{
    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    void findCharacterThatHasOneMatchOnList()
    {
        // Arrange
        String charName = "Luke";
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke SkyWalker");
        List<CharacterDTO> characterDTOList = List.of(luke);
        // Act
        Mockito.when(repository.findAllByNameContains(charName)).thenReturn(characterDTOList);
        List<CharacterDTO> response = service.find(charName);
        // Assert
        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertAll(
                () -> assertEquals("Luke SkyWalker", response.get(0).getName()),
                () -> assertEquals(1, response.size())
        );
    }

    @Test
    void findCharacterWhoDoesNotExist()
    {
        // Arrange
        String charName = "Not Found";
        List<CharacterDTO> characterDTOList = new LinkedList<>();
        // Act
        Mockito.when(repository.findAllByNameContains(charName)).thenReturn(characterDTOList);
        List<CharacterDTO> response = service.find(charName);
        // Assert
        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertAll(
                () -> assertEquals(0, response.size())
        );
    }
}