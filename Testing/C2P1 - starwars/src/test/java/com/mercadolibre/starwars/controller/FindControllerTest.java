package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    void NotFindAllByNameContains(){
        // Arrange
        String name = "NOT FOUND";

        // Act
        List<CharacterDTO> characterDTOList = repository.findAllByNameContains(name);

        // Assert
        Assertions.assertTrue(characterDTOList.isEmpty());
    }

    @Test
    void findAllByNameContains(){
        // Arrange
        String name = "Darth";
        CharacterDTO darthVader = new CharacterDTO("Darth Vader");
        CharacterDTO darthMaul = new CharacterDTO("Darth Maul");
        List<CharacterDTO> characterDTOList = List.of(darthVader, darthMaul);

        // Act
        when(repository.findAllByNameContains(name)).thenReturn(characterDTOList);
        List<CharacterDTO> result = service.find(name);

        // Assert
        assertEquals(result, characterDTOList);
        assertEquals(result.size(), 2);
    }
}
