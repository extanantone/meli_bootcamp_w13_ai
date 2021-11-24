package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findAllByNameContains() {
        // Arrange
        String name = "Leia";
        CharacterDTO leia = new CharacterDTO();
        leia.setName("Leia Organa");
        List<CharacterDTO> expect = List.of(leia);

        // Act
        Mockito.when(service.find(name)).thenReturn(expect);
        List<CharacterDTO> actual = controller.find(name);

        // Assert
        Mockito.verify(service, Mockito.atLeastOnce()).find(name);
        Assertions.assertAll(
                () -> Assertions.assertEquals(actual.get(0).getName(), expect.get(0).getName()),
                () -> Assertions.assertEquals(actual.size(), expect.size(), 1)
        );
    }

    @Test
    void NotFindController() {
        // Arrange
        String name = "NOT FOUND";

        // Act
        List<CharacterDTO> characterDTOList = controller.find(name);

        // Assert
        Assertions.assertTrue(characterDTOList.isEmpty());
    }
}
