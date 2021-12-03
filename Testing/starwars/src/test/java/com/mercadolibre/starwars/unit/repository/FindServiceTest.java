package com.mercadolibre.starwars.unit.repository;

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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl repo;

    @InjectMocks
    FindService findService;

    @Test
    void find(){
        //Arrange
        String find = "Luke";

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");

        List<CharacterDTO> listaMock = new ArrayList<>();

        listaMock.add(luke);

        Mockito.when(repo.findAllByNameContains(find)).thenReturn(listaMock);

        //Act
        List<CharacterDTO> result = findService.find(find);

        //Assert
        Assertions.assertAll(
                () ->    Mockito.verify(repo, Mockito.atLeastOnce()).findAllByNameContains(find),
                () ->    Assertions.assertEquals(1, result.size()),
                () ->    Assertions.assertEquals("Luke Skywalker", result.get(0).getName()));
    }
}
