package com.mercadolibre.linktracker.unit.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.service.LinkService;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)

public class LinkServiceTest {

    @Mock
private LinkRepositoryImpl linkRepository;

    @InjectMocks
    //El que se inyecta no puede ir como interfaz
    private LinkServiceImpl linkService;


    @Test
    @DisplayName("Creacion Del Link Exitosa")
    void create() {
        //Arrange
        LinkDTO link = new LinkDTO();
        link.setLinkId(12);
        link.setLink("https://www.digitalhouse.com");
        link.setPassword("hola");

        //Act
        Mockito.when(linkRepository.save(link)).thenReturn(link);
        linkService.create(link);

        //Assert
        Mockito.verify(linkRepository, Mockito.atLeastOnce()).save(link);
    }

    @Test
    @DisplayName("Redireccionamiento Exitoso")
    void redirect() {
        //Arrange
        LinkDTO link = new LinkDTO();
        link.setLinkId(12);
        link.setLink("https://www.digitalhouse.com");
        link.setPassword("hola");

        //Act
        Mockito.when(linkRepository.findLinkByLinkId(link.getLinkId())).thenReturn(Optional.of(link));
        LinkDTO expected = linkService.redirect(link.getLinkId(), link.getPassword());

        //Assert
        Mockito.verify(linkRepository, Mockito.atLeastOnce()).findLinkByLinkId(Mockito.anyInt());
//        verify(linkRepository, atLeastOnce()).findLinkByLinkId(link.getLinkId());
        Assertions.assertEquals(expected, link);

    }
    @Test
    @DisplayName("Redireccionamiento Erroneo Por Password Incorrecto")
    void errorToRedirectByPsw() {
        //Arrange
        LinkDTO link = new LinkDTO();
        link.setLinkId(12);
        link.setLink("https://www.digitalhouse.com");

        //Act
        Mockito.when(linkRepository.findLinkByLinkId(link.getLinkId())).thenReturn(Optional.of(link));
        LinkDTO expected = linkService.redirect(link.getLinkId(), link.getPassword());

        //Assert
        Mockito.verify(linkRepository, Mockito.atLeastOnce()).findLinkByLinkId(Mockito.anyInt());
//        verify(linkRepository, atLeastOnce()).findLinkByLinkId(link.getLinkId());
        Assertions.assertNull(expected);

    }
    @Test
    @DisplayName("Redireccionamiento Sin Efecto, Resultado Nulo")
    void errorToRedirect() {
        //Arrange
        Integer id = 8;
        String psw = "Hola";

        //Act
        Mockito.when(linkRepository.findLinkByLinkId(id)).thenReturn(Optional.empty());
        LinkDTO expectedNull = linkService.redirect(id,psw);

        //Assert
        Mockito.verify(linkRepository, Mockito.atLeastOnce()).findLinkByLinkId(Mockito.anyInt());
        Assertions.assertNull(expectedNull);

    }

    @Test
    void testRedirect() {
    }

    @Test
    void metrics() {
    }

    @Test
    void invalidate() {
    }
}
