package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void nameToSearchFindAllResults() {

        //Assert
        String name = "Darth";

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");

        List<CharacterDTO> expectedResult = Arrays.asList(darthVader, darthMaul);

        //Mock
        Mockito.when(findService.find(name)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> currentResult = findController.find(name);

        //Assert
        Assertions.assertEquals(expectedResult.get(0).getName(), currentResult.get(0).getName());
        Assertions.assertEquals(expectedResult.get(1).getName(), currentResult.get(1).getName());
        Assertions.assertEquals(2, currentResult.size());
    }

    @Test
    public void nameToSearchIsNotFoundByTheController() {

        //Assert
        String name = "banana";

        List<CharacterDTO> expectedResult = Collections.emptyList();

        //Mock
        Mockito.when(findService.find(name)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> currentResult = findController.find(name);

        //Assert
        Assertions.assertEquals(expectedResult, currentResult);
    }
}
