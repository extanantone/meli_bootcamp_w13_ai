package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void nameToSearchFindAllResults() {

        //Arrange
        String name = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");

        List<CharacterDTO> expectedResult = Arrays.asList(darthMaul, darthVader);

        //Mock
        Mockito.when(characterRepository.findAllByNameContains(name)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> currentResult = findService.find(name);

        //Assert
        Assertions.assertEquals(expectedResult.get(0).getName(), currentResult.get(0).getName());
        Assertions.assertEquals(expectedResult.get(1).getName(), currentResult.get(1).getName());
        Assertions.assertEquals(2, currentResult.size());
    }

    @Test

    public void nameToSearchIsNotFound() {

        //Arrange
        String name = "banana";

        List<CharacterDTO> expectedResult = Collections.emptyList();

        //Mock
        Mockito.when(characterRepository.findAllByNameContains(name)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> currentResult = findService.find(name);

        //Assert
        Assertions.assertEquals(expectedResult, currentResult);
    }
}
