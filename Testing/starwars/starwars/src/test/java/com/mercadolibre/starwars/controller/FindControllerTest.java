package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService mockFindService;

    @InjectMocks
    FindController findController;

    @Test
    void shouldFindDarths() {
        // Arrange
        String query = "Darth";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Darth Pizza");
        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Darth Maullido");
        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO3.setName("Darth-Balder every day");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1, characterDTO2, characterDTO3);

        when(mockFindService.find(query)).thenReturn(characterDTOList);

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert
        assertEquals(characterDTOList.size(), result.size());

        assertEquals(characterDTOList.get(0).getName(), result.get(0).getName());

        verify(mockFindService, atLeastOnce()).find(query);
    }

    @Test
    void shouldFindNothing() {
        // Arrange
        String query = "Darth";

        when(mockFindService.find(query)).thenReturn(new ArrayList<CharacterDTO>());

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert
        assertEquals(0, result.size());

        verify(mockFindService, atLeastOnce()).find(query);
    }
}
