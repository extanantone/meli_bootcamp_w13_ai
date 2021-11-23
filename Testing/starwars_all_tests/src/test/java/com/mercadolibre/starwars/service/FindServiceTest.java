package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository mockRepo;

    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Encontrar a todos los personajes por nombre en el service")
    void findCharactersByName(){
        //Arrange
        String query = "Luke";
        List<CharacterDTO> awaitedCharacters = new ArrayList<>();
        CharacterDTO c1 = new CharacterDTO();
        c1.setName("Luke Skywalker");
        awaitedCharacters.add(c1);

        //Act
        when(mockRepo.findAllByNameContains(query)).thenReturn(awaitedCharacters);
        List<CharacterDTO> response = findService.find(query);

        //Assert
        verify(mockRepo, atLeast(1)).findAllByNameContains(query);
        Assertions.assertEquals(awaitedCharacters, response);
        //Assertions.assertSame(awaitedCharacters, response);
    }

    @Test
    @DisplayName("No se encuentran resultados para el personaje enviado por parametro")
    void findNotCoincidenceByCharacterName(){
        //Arrange
        String query = "sadafasdfssdaf";
        List<CharacterDTO> awaitedCharacters = new ArrayList<>();

        //Act
        when(mockRepo.findAllByNameContains(query)).thenReturn(awaitedCharacters);
        List<CharacterDTO> response = findService.find(query);

        //Assert
        //Assertions.assertEquals(awaitedCharacters, response);
        //Assertions.assertEquals(awaitedCharacters.size(), response.size());
        Assertions.assertTrue(response.isEmpty());

        verify(mockRepo, atLeastOnce()).findAllByNameContains(Mockito.anyString());
    }

}
