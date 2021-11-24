package com.mercadolibre.starwars.unit;

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
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    //mock
    @Mock
    FindService service;

    //lo que quiero testear
    @InjectMocks
    FindController findController;


    @Test
    public void findController()
    {
        // Arrange
        String nameToSearch = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        List<CharacterDTO> expectedDarthCast = Arrays.asList(darthVader, darthMaul);
        //Mock
        Mockito.when(service.find(nameToSearch)).thenReturn(expectedDarthCast);

        // Act
        List <CharacterDTO> currentDarkList = findController.find(nameToSearch);

        // Assert
        Mockito.verify(service.find(nameToSearch), Mockito.atLeastOnce());
        Assertions.assertAll(() -> Assertions.assertEquals(expectedDarthCast.get(0).getName(), currentDarkList.get(0).getName()),
            () -> Assertions.assertEquals(expectedDarthCast.get(1).getName(), currentDarkList.get(1).getName()),
            () -> Assertions.assertEquals(2, currentDarkList.size())
        );
    }

    @Test
    public void nameToSearchIsNotFoundInRepository() {
        String nameToSearch = "Banana";
        List<CharacterDTO> resultDarthCast = findController.find(nameToSearch);

        Assertions.assertTrue(resultDarthCast.isEmpty());
    }
}