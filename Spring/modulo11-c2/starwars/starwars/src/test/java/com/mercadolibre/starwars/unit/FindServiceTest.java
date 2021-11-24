package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    void nameDoesExist() {
        // Arrange
        String nameToSearch = "Darth";

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");

        List<CharacterDTO> expectedList = Arrays.asList(darthVader, darthMaul);

        // Mocks
        Mockito.when(repository.findAllByNameContains(nameToSearch)).thenReturn(expectedList);

        // Act
        List<CharacterDTO> resultList = service.find(nameToSearch);

        // Assert
        Mockito.verify(repository.findAllByNameContains(nameToSearch), Mockito.atLeastOnce());
        Assertions.assertAll(() -> Assertions.assertEquals(expectedList.get(0).getName(), resultList.get(0).getName()),
                () -> Assertions.assertEquals(expectedList.get(1).getName(), resultList.get(1).getName()),
                () -> Assertions.assertEquals(2, resultList.size())
        );
    }

    @Test
    public void nameToSearchIsNotFoundInRepository() {
        String nameToSearch = "Banana";
        List<CharacterDTO> resultDarthCast = service.find(nameToSearch);

        Assertions.assertTrue(resultDarthCast.isEmpty());
    }
}