package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
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

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService mockFindService;

    @InjectMocks
    private FindController findController;

    @Test
    void shouldFindCharactersByName(){
        //Arrange
        String query= "Darth";

        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Darth Vader");
        characterDTO1.setHair_color("Brown");

        CharacterDTO characterDTO2 =  new CharacterDTO();
        characterDTO2.setName("Dath Maul");
        characterDTO2.setHair_color("Black");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1,characterDTO2);
        when(mockFindService.find(query)).thenReturn(characterDTOList);

        //Act

        List<CharacterDTO>  result = findController.find(query);

        //Assert

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getName(),"Darth Vader");
        verify(mockFindService,atLeastOnce()).find(query);

    }

}