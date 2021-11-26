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
        String query = "Darth";

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        List<CharacterDTO> expectedDarthCast = Arrays.asList(darthVader, darthMaul);
        //Mock
        Mockito.when(service.find(query)).thenReturn(expectedDarthCast);

        // Act
        List <CharacterDTO> currentDarkList = findController.find(query);

        // Assert
        Assertions.assertEquals(expectedDarthCast.get(0).getName(), currentDarkList.get(0).getName());
        Assertions.assertEquals(expectedDarthCast.get(1).getName(), currentDarkList.get(1).getName());
        Assertions.assertEquals(2, currentDarkList.size());

        // Assert & verificar uso de mocks
        Mockito.verify(service, Mockito.atLeastOnce()).find(Mockito.anyString());
        //Mockito.verify(repo, Mockito.atLeast(3)).findIngredientByName(ingredient.getName());


    }
}
