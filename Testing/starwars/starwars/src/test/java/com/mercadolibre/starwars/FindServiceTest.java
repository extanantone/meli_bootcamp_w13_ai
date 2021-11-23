package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repo;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("When find characters include name Luke")
    void test1() {

        // Arrange
        String name = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");

        List<CharacterDTO> expected = List.of(character);

        Mockito.when(repo.findAllByNameContains(name)).thenReturn(expected);
        // Act

        List<CharacterDTO> current = service.find(name);

        // Assert
        Mockito.verify(repo,Mockito.atLeastOnce()).findAllByNameContains(name);
        Assertions.assertEquals(expected.get(0).getName(),current.get(0).getName());
        Assertions.assertEquals(current.size(),1);
    }
}
