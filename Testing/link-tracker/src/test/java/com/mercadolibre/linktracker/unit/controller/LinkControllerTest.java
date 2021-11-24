package com.mercadolibre.linktracker.unit.controller;

import com.mercadolibre.linktracker.controller.LinkController;
import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.service.LinkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LinkControllerTest  {

    @Mock
    LinkService service;

    @InjectMocks
    LinkController controller;

    @Test
    void createTest(){
        //arrange
        LinkDTO dto = new LinkDTO();
        dto.setLink("https://www.mercadolibre.com");

        //act
        controller.create(dto);


        //assert
        Mockito.verify(service, Mockito.atLeastOnce()).create(dto);
    }

    @Test
    void createTestV2 (){
        //arrange
        LinkDTO dto = new LinkDTO();
        dto.setLink("https://www.mercadolibre.com");

        LinkDTO rta = new LinkDTO();
        rta.setLink("https://www.mercadolibre.com");



        //act

        Mockito.when(service.create(dto)).thenReturn(rta);


        //assert
        Assertions.assertEquals(dto.getLink(), rta.getLink());

    }


}
