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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService mockFindService;

    @InjectMocks
    private FindController findController;

    @Test
    void CharacterNotFoundTest(){
        //Arrange
        String query = "dsafsafdsa";
        List<CharacterDTO> emptyList = new ArrayList<>();

        //Act
        when(mockFindService.find(Mockito.anyString())).thenReturn(emptyList);
        List<CharacterDTO> current = findController.find(query);

        //Assert
        //Assertions.assertEquals(current.size(), 0);
        Assertions.assertTrue(current.isEmpty());
        verify(mockFindService, atLeast(1)).find(Mockito.anyString());
    }

    @Test
    void CharacterFoundSuccessfullyTest(){
        //Arrange
        String query = "Darth";
        CharacterDTO c1 = new CharacterDTO();
        c1.setName("Darth Vader");
        CharacterDTO c2 = new CharacterDTO();
        c2.setName("Darth Maul");

        List<CharacterDTO> charactersExpected = Arrays.asList(c1, c2);

        //Act
        when(mockFindService.find(Mockito.anyString())).thenReturn(charactersExpected);
        List<CharacterDTO> current = findController.find(query);

        //Assert
        //Assertions.assertEquals(2, current.size());
        Assertions.assertEquals(charactersExpected, current);
        verify(mockFindService, atLeast(1)).find(query);
    }
}
