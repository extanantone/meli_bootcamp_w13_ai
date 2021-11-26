package com.mercadolibre.starwars.unitary.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utils.Repo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repo;

    @InjectMocks
    FindService service;

    @Test
    void findAllByNameContains(){

        //Arrange
        String query = "Luke";
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");

        //Mocks
        Mockito.when(repo.findAllByNameContains(query)).thenReturn(Repo.SetCharacterDTO());
        //Act
        List<CharacterDTO> current = service.find(query);

        List<CharacterDTO> expect = Repo.SetCharacterDTO();

        //Assert
        Assertions.assertEquals(expect.get(0),current.get(0));
        Mockito.verify(repo,Mockito.atLeastOnce()).findAllByNameContains(query);

    }



}
