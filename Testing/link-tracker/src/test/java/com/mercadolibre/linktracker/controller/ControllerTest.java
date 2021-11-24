package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.service.LinkService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private LinkController controller;

    @Mock
    private LinkService service;


    @Test
    public void shouldBeRedirect(){
        try {
            Mockito.when(service.redirect(1)).thenReturn(new LinkDTO(1, "https://www.google.com.co", "", 0));
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = new MockHttpServletResponse();
            controller.redirect(1, response);
            assertTrue(response.getStatus()>=300 && response.getStatus()<400);
            assertEquals(response.getHeader("Location"),"https://www.google.com.co");
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldntBeRedirectWithOutRedirect(){
        try {
            Mockito.when(service.redirect(1)).thenReturn(null);
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = new MockHttpServletResponse();
            controller.redirect(1, response);
            assertEquals(response.getStatus(),404);
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
