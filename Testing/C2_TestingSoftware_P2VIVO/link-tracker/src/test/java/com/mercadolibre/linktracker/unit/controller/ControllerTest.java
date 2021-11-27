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


    //public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {

    @Test
    public void testRedirectWithCorrectLinkId() throws IOException {
        //Ar
        LinkDTO link = new LinkDTO();
        link.setLinkId(0);
        link.setLink("https://www.google.com");

        HttpServletResponse httpResponse = new MockHttpServletResponse();
        //Ac
        when(mockLinkService.redirect(0))
                .thenReturn(link);
        linkController.redirect(0,httpResponse);

        //As
        Assertions.assertNotEquals(HttpStatus.NOT_FOUND.value(),httpResponse.getStatus());
        //verify(mockLinkService,atLeast(1)).redirect();
    }

    @Test
    public void testRedirectWithIncorrectLinkId() throws IOException {
        //Ar
        LinkDTO link = new LinkDTO();
        link.setLinkId(0);
        link.setLink("https://www.google.com");

        HttpServletResponse httpResponse = new MockHttpServletResponse();
        //Ac
        when(mockLinkService.redirect(0))
                .thenReturn(link);
        linkController.redirect(0,httpResponse);

        //As
        Assertions.assertNotEquals(HttpStatus.NOT_FOUND.value(),httpResponse.getStatus());

    }
}
