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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    void findCharacter() {
        // Arrange
        String name = "Leia";
        CharacterDTO leia = new CharacterDTO();
        leia.setName("Leia Organa");
        List<CharacterDTO> expect = List.of(leia);

        // Act
        Mockito.when(repository.findAllByNameContains(name)).thenReturn(expect);
        List<CharacterDTO> actual = service.find(name);

        // Assert
        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertAll(
                () -> Assertions.assertEquals(actual.get(0).getName(), expect.get(0).getName()),
                () -> Assertions.assertEquals(actual.size(), expect.size(), 1)
        );
    }

    @Test
    void NotFindCharacter() {
        // Arrange
        String name = "NOT FOUND";
        List<CharacterDTO> expect = new ArrayList<>();

        // Act
        Mockito.when(repository.findAllByNameContains(name)).thenReturn(expect);
        List<CharacterDTO> actual = service.find(name);

        // Assert
        Mockito.verify(repository, Mockito.atLeastOnce()).findAllByNameContains(Mockito.anyString());
        Assertions.assertTrue(actual.isEmpty());
    }
}
