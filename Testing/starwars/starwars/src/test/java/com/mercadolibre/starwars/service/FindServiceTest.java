package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository mockCharacterRepository;

    @InjectMocks
    FindService findService;

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

        when(mockCharacterRepository.findAllByNameContains(query)).thenReturn(characterDTOList);

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(characterDTOList.size(), result.size());

        assertEquals(characterDTOList.get(0).getName(), result.get(0).getName());

        verify(mockCharacterRepository, atLeastOnce()).findAllByNameContains(query);
    }

    @Test
    void shouldFindNothing() {
        // Arrange
        String query = "Darth";

        when(mockCharacterRepository.findAllByNameContains(query)).thenReturn(new ArrayList<CharacterDTO>());

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(0, result.size());

        verify(mockCharacterRepository, atLeastOnce()).findAllByNameContains(query);
    }
}
