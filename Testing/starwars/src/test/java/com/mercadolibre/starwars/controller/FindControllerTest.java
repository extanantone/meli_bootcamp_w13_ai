package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTest
{
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findControllerWorking()
    {
        //arrange
        String charName = "Luke";
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke SkyWalker");
        List<CharacterDTO> expected = List.of(luke);
        //act
        Mockito.when(service.find(charName)).thenReturn(expected);
        List<CharacterDTO> result = controller.find(charName);
        //assert
        Mockito.verify(service, Mockito.atLeastOnce()).find(charName);
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName())
        );
    }
}