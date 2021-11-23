package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void FindCharacter(){
       //Arrange
        String characterName= "l";
        CharacterDTO characterDTO= new CharacterDTO();
        characterDTO.setName(characterName);

        List<CharacterDTO> myList= List.of(characterDTO);

        //Mocks
        //Este agrega contenido al repo
        Mockito.when(
                characterRepository
                        .findAllByNameContains(characterDTO.getName()))
                .thenReturn(myList);

        //Act
        List<CharacterDTO> current= findService.find(characterName);

        //Assert
        //Este verifica si se ha utilizado el repositorio con el metodo atLeastOnce
        Mockito.verify(characterRepository, Mockito.atLeastOnce())
                .findAllByNameContains(Mockito.anyString());
        Assertions.assertEquals(current, myList);
    }
}
