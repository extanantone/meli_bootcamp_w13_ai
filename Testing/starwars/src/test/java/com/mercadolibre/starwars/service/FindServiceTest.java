package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
     CharacterRepositoryImpl repository;

    @InjectMocks
    FindService findService;


    @Test
    void find() {
       //Arrange
        String find = "Luke";

        CharacterDTO luke = new CharacterDTO();
        CharacterDTO luke2 = new CharacterDTO();
        CharacterDTO luke3 = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke2.setName("Luke walker");
        luke3.setName("Luke Sky");

        List<CharacterDTO> listaMock = new ArrayList<>();
        listaMock.add(luke);
        listaMock.add(luke2);
        listaMock.add(luke3);



       //Act
        Mockito.when(repository.findAllByNameContains(find)).thenReturn(listaMock);
        List<CharacterDTO> result = findService.find(find);
        List<CharacterDTO> result2 = findService.find(find);
        List<CharacterDTO> result3 = findService.find(find);

       //Assert
        assertEquals("Luke Skywalker", result.get(0).getName());
       // Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains(find);
        Mockito.verify(repository, Mockito.atLeast(3)). findAllByNameContains(find);
    }
}