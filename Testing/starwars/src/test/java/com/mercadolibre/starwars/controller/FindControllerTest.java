package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService mockFindService;

    @InjectMocks
    private FindController mockFindController;

    private CharacterDTO character1;
    private CharacterDTO character2;

    @BeforeEach
    void setUp() {
        character1 = new CharacterDTO("Darth vader");
        character2 = new CharacterDTO("Darth mockito");
    }

    @Test
    void findCharacterByName() {
        String query = "Darth";
        List<CharacterDTO> dtoList = Arrays.asList(character1, character2);
        when(mockFindService.find(query)).thenReturn(dtoList);

        List<CharacterDTO> result = mockFindController.find(query);
        verify(mockFindService, atLeast(1)).find(query);

        assertEquals(dtoList, result);
        assertEquals(result.get(0).getName(), character1.getName());
        assertEquals(result.size(), 2);
    }
}
