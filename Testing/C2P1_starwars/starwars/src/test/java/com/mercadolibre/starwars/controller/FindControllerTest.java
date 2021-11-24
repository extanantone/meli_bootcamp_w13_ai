package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService mockFindService;

    @InjectMocks
    private FindController findController;

    @Test
    void shouldFindCharacterByName(){
        // Arrange
        String query = "Darth";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Darth Vader");
        characterDTO1.setHair_color("Brown");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Darth Paul");
        characterDTO2.setHair_color("Black");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1, characterDTO2);
        when(mockFindService.find(query)).thenReturn(characterDTOList);

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert
        // Verifica que el tamaño de la lista resultante sea igual que dos
        assertEquals(result.size(), 2);
        // Verifica que el nombre del primer elemento de la lista resultante sea Darth Vader
        assertEquals(result.get(0).getName(), "Darth Vader");
        // Verifica que el método se haya ejecutado al menos una vez.
        verify(mockFindService, atLeastOnce()).find(query);

    }
}
