package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDTO;
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

    @Test
    public void firstCreatedLinkHasIdZero() {
        LinkDTO firstLink = new LinkDTO(null, "http://google.com", null, 0);
        LinkDTO expectedLink = new LinkDTO();
        expectedLink.setLinkId(0);
        Mockito.when(service.create(firstLink)).thenReturn(expectedLink);

        LinkDTO createdLink = service.create(firstLink);

        Mockito.verify(service, Mockito.times(1)).
                create(Mockito.any(LinkDTO.class));
        assertEquals(0, createdLink.getLinkId());
    }

    @Test
    public void newCreatedLinkHasDifferentId() {
        LinkDTO firstLink = new LinkDTO(null, "http://google.com", null, 0);
        LinkDTO firstCreatedLink = new LinkDTO(0, "http://google.com", null, 0);
        LinkDTO secondLink = new LinkDTO(null, "http://facebook.com", null, 0);
        LinkDTO secondCreatedLink = new LinkDTO(1, "http://facebook.com", null, 0);
        Mockito.when(service.create(firstLink)).thenReturn(firstCreatedLink);
        Mockito.when(service.create(secondLink)).thenReturn(secondCreatedLink);

        LinkDTO previousLink = service.create(firstLink);
        LinkDTO newLink = service.create(secondLink);

        assertNotEquals(previousLink.getLinkId(), newLink.getLinkId());
    }


}
