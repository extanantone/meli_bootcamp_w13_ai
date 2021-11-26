package com.mercadolibre.linktracker.unitary;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.util.LinKs;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.Utilities;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LinkRepositoryImplTest {

   LinkRepositoryImpl linkRepository = new LinkRepositoryImpl();

    @AfterAll
    void lena(){

        linkRepository.save(LinKs.getdabase().get(0));
        linkRepository.save(LinKs.getdabase().get(1));
    }


    @Test
    void whenfindLinkByLinkIdthenOneFind(){

        //arrange
        LinkDTO link = new LinkDTO();
        link.setLink("google");
        link.setCount(1);
        link.setPassword("1234");
        link.setLinkId(1);
        linkRepository.save(link);

        LinkDTO curret = linkRepository.findLinkByLinkId(0).get();

        Assertions.assertEquals(1,curret.getLinkId());
    }

    @Test
    void whensaveLinkByLinkIdthenOnesave(){

        LinkDTO link = new LinkDTO();
        link.setLink("google");
        link.setCount(1);
        link.setPassword("1234");

        linkRepository.save(LinKs.getdabase().get(1));
        LinkDTO current = linkRepository.save(link);
        Assertions.assertEquals(1,link.getLinkId());

    }

    @Test
    void whenDeleteThenDelete1(){

        //arrange
        LinkDTO link = new LinkDTO();
        link.setLink("google");
        link.setCount(1);
        link.setPassword("1234");
        link.setLinkId(1);

        Map<Integer, LinkDTO> database = LinKs.getdabase();
    }
}
