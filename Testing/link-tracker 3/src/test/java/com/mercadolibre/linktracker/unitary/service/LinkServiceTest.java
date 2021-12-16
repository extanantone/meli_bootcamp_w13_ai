package com.mercadolibre.linktracker.unitary.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.service.LinkService;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LinkServiceTest {

    @Mock
    LinkRepository linkRepository;

    @InjectMocks
    LinkServiceImpl linkServiceImpl;

    @Test
    public void createLink(){
        //Arrange
        LinkDTO link1= new LinkDTO(1, "www.mercadolibre.com", "123987", 0);
        LinkDTO link2= new LinkDTO(2, "www.mercadolibre.com", "123987", 0);
        Mockito.when(linkRepository.save(link1)).thenReturn(link2);

        //Act
        LinkDTO response= linkServiceImpl.create(link1);

        //Assert
        Mockito.verify(linkRepository, Mockito.atLeastOnce()).save(link1);
        Assertions.assertEquals(response.getLinkId(), link1.getLinkId());
    }

    @Test
    public void redirectLink(){
        //Arrange
        LinkDTO link1= new LinkDTO(1, "www.mercadolibre.com", "123987", 0);
        LinkDTO link2= new LinkDTO(2, "www.mercadolibre.com", "123987", 0);
        Mockito.when(linkRepository.save(link1)).thenReturn(link2);
        LinkDTO response= linkServiceImpl.create(link1);

        //Act 

        //Assert
        Mockito.verify(linkRepository, Mockito.atLeastOnce()).save(link1);
        Assertions.assertEquals(response.getLinkId(), link1.getLinkId());
    }



    /*
    LinkDTO create(LinkDTO link);

      LinkDTO redirect(Integer linkId);

      LinkDTO redirect(Integer linkId, String password);

      LinkDTO metrics(Integer linkId);

      void invalidate(Integer linkId);
     */
}
