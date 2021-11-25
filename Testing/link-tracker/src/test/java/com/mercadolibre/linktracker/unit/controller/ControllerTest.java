package com.mercadolibre.linktracker.unit.controller;

import com.mercadolibre.linktracker.controller.LinkController;
import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.service.LinkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    LinkService mockLinkService;

    @InjectMocks
    LinkController linkController;

    @Test
    public void testCreateLinkValid(){
        //Arrange
        Integer id = 0;
        LinkDTO linkValid = new LinkDTO();
        linkValid.setLinkId(id);

        //Act
        when(mockLinkService.create(linkValid)).thenReturn(linkValid);
        LinkDTO linkCurrent = linkController.create(linkValid);

        //Assert
        Assertions.assertSame(linkValid, linkCurrent); //es el mismo objeto
        verify(mockLinkService, atLeastOnce()).create(linkValid);
    }


    //public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {

    @Test
    public void testRedirectWithCorrectLinkId() throws IOException {
        //Arrange
        Integer id = 0;
        LinkDTO linkReturned = new LinkDTO();
        linkReturned.setLinkId(id);
        linkReturned.setLink("https://www.google.com/");

        HttpServletResponse httpResponse = new MockHttpServletResponse();

        //Act
        when(mockLinkService.redirect(id)).thenReturn(linkReturned);
        linkController.redirect(id, httpResponse);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(HttpStatus.NOT_FOUND.value(), httpResponse.getStatus()),
                () -> Assertions.assertNotNull(linkReturned),
                () -> Assertions.assertNotNull(linkReturned.getLink()),
                () -> Assertions.assertEquals(linkReturned.getLink(), ((MockHttpServletResponse) httpResponse).getRedirectedUrl())
        );
        verify(mockLinkService, atLeast(1)).redirect(id);
    }

    @Test
    public void testRedirectWithIncorrectLinkId() throws IOException {
        //Arrange
        Integer idNotFound = 555;
        HttpServletResponse httpResponse = new MockHttpServletResponse();

        //Act
        when(mockLinkService.redirect(idNotFound)).thenReturn(null);
        linkController.redirect(idNotFound, httpResponse);

        //Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), httpResponse.getStatus());
        verify(mockLinkService, atLeastOnce()).redirect(idNotFound);
    }

    @Test
    public void testRedirectWithCorrectLinkIdAndPassword() throws IOException {
        //Arrange
        Integer id = 0;
        String passwd = "1234";
        LinkDTO linkReturned = new LinkDTO();
        linkReturned.setLinkId(id);
        linkReturned.setPassword("1234");
        linkReturned.setLink("https://www.google.com/");

        HttpServletResponse httpResponse = new MockHttpServletResponse();

        //Act
        when(mockLinkService.redirect(id, passwd)).thenReturn(linkReturned);
        linkController.redirect(id, passwd, httpResponse);

        //Assert
        Assertions.assertAll(
            () -> Assertions.assertNotEquals(HttpStatus.NOT_FOUND.value(), httpResponse.getStatus()),
            () -> Assertions.assertNotNull(linkReturned),
            () -> Assertions.assertNotNull(linkReturned.getLink()),
            () -> Assertions.assertEquals(linkReturned.getLink(), ((MockHttpServletResponse) httpResponse).getRedirectedUrl())
        );
        verify(mockLinkService, atLeast(1)).redirect(id, passwd);
    }

    @Test
    public void testRedirectWithIncorrectLinkIdAndPassword() throws IOException {
        //Arrange
        Integer idNotFound = 555;
        String passwd = "1234";
        HttpServletResponse httpResponse = new MockHttpServletResponse();

        //Act
        when(mockLinkService.redirect(idNotFound, passwd)).thenReturn(null);
        linkController.redirect(idNotFound, passwd, httpResponse);

        //Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), httpResponse.getStatus());
        verify(mockLinkService, atLeastOnce()).redirect(idNotFound, passwd);
    }

    @Test
    public void testGetMetricsWithExistingId(){
        //Arrange
        Integer id = 0;
        LinkDTO linkSaved = new LinkDTO();
        linkSaved.setLinkId(id);

        //Act
        when(mockLinkService.metrics(id)).thenReturn(linkSaved);
        LinkDTO linkCurrent = linkController.metrics(id);

        //Assert
        Assertions.assertEquals(linkSaved, linkCurrent);
        verify(mockLinkService, atLeastOnce()).metrics(id);
    }

    @Test
    public void testGetMetricsWithNotFoundId(){
        //Arrange
        Integer id = 555;

        //Act
        when(mockLinkService.metrics(id)).thenReturn(null);
        LinkDTO linkCurrent = linkController.metrics(id);

        //Assert
        Assertions.assertNull(linkCurrent);
        verify(mockLinkService, atLeastOnce()).metrics(anyInt());
    }
}
