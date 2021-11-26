package com.mercadolibre.linktracker.unitary;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import com.mercadolibre.linktracker.util.LinKs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LinkServiceImplTest {

    @Mock
    LinkRepository linkRepository;

    @InjectMocks
    LinkServiceImpl service;

    LinkDTO expect = new LinkDTO();
    {
        expect.setLink("https://www.google.com/");
        expect.setCount(1);
        expect.setPassword("1234");
        expect.setLinkId(1);
    }



    @Test
    void redirectTest(){


        Mockito.when(linkRepository.findLinkByLinkId(1)).thenReturn(Optional.of(expect));

        LinkDTO current = service.redirect(1);

        Assertions.assertEquals(expect.getLinkId(),current.getLinkId());
        Mockito.verify(linkRepository,Mockito.atLeastOnce()).findLinkByLinkId(1);
    }

    @Test
    void redirectTestPassOK(){

        Mockito.when(linkRepository.findLinkByLinkId(1)).thenReturn(Optional.of(expect));

        LinkDTO current = service.redirect(1,"1234");

        Assertions.assertEquals(expect.getLinkId(),current.getLinkId());
        Mockito.verify(linkRepository,Mockito.atLeastOnce()).findLinkByLinkId(1);
    }

    @Test
    void redirectTestPassNot(){

        Mockito.when(linkRepository.findLinkByLinkId(1)).thenReturn(Optional.of(expect));

        LinkDTO current = service.redirect(1,"1234");

        Assertions.assertEquals(expect.getLinkId(),current.getLinkId());
        Mockito.verify(linkRepository,Mockito.atLeastOnce()).findLinkByLinkId(1);
    }

    @Test
    void saveOk(){

        LinkDTO expectSave = new LinkDTO();

        Mockito.when(linkRepository.save(expectSave)).thenReturn(expect);

        LinkDTO current = service.create(expectSave);

        Assertions.assertEquals(expect.getLinkId(),current.getLinkId());
        Mockito.verify(linkRepository,Mockito.atLeastOnce()).save(expectSave);
    }

    @Test
    void invalidate(){

        Mockito.when(linkRepository.findLinkByLinkId(1)).thenReturn(Optional.of(expect));


    }

}
