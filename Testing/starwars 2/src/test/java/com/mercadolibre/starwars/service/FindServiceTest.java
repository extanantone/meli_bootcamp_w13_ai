package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository mockCharacterRepository;

    @InjectMocks
    private FindService mockFindService;

    @Test
    void findAllByName() {
        String query = "Luke";
        CharacterDTO chr = new CharacterDTO("Luke Skywalker");
        List<CharacterDTO> dtoList = List.of(chr);

        when(mockCharacterRepository.findAllByNameContains(query)).thenReturn(dtoList);

        List<CharacterDTO> result = mockFindService.find(query);

        assertEquals(result, dtoList);
        assertEquals(result.size(), 1);
        verify(mockCharacterRepository, atLeast(1)).findAllByNameContains(query);

    }
}
