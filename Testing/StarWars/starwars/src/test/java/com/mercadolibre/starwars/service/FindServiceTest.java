package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository mockRepo;

    @InjectMocks
    FindService findService;


    @Test
    @DisplayName("Encontrar a todos los personajes por nombre en el service")
    void findCharactersByName(){

        //Arrange
        String query = "Darth";
        List<CharacterDTO> response;
        List<CharacterDTO> awaitedCharacters = new ArrayList<>();
        List<CharacterDTO> emptyList = new ArrayList<>();

        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        c1.setName("Darth Vader");
        c2.setName("Darth Maul");

        awaitedCharacters.add(c1);
        awaitedCharacters.add(c2);

        //Act
        //when(mockRepo.findAllByNameContains(query)).thenReturn(awaitedCharacters);
        response = findService.find(query);

        //Assert
        //Assertions.assertEquals(awaitedCharacters,response);
        verify(mockRepo,atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertSame(awaitedCharacters,response);

    }

    @Test
    @DisplayName("No se encuentran resultados para el personaje enviado por parametro")
    void findNotCoincidenceByCharacterName(){

        //Arrange
        String query = "Darth";
        List<CharacterDTO> response;
        List<CharacterDTO> awaitedCharacters = new ArrayList<>();

        //Act
        //when(mockRepo.findAllByNameContains(query)).thenReturn(awaitedCharacters);
        response = findService.find(query);

        //Assert
        //Assertions.assertEquals(awaitedCharacters,response);
        Assertions.assertTrue(awaitedCharacters.size() == response.size());

        verify(mockRepo,atLeastOnce()).findAllByNameContains(Mockito.anyString());

    }


}
