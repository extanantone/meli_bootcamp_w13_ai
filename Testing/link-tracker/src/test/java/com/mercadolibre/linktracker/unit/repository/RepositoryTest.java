package com.mercadolibre.linktracker.unit.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class RepositoryTest {
    private LinkRepositoryImpl linkRepository = new LinkRepositoryImpl();

    @BeforeEach
    public  void saveLink(){
        LinkDTO link = new LinkDTO();
        link.setLinkId(0);
        link.setLink("https://www.mercadolibre.com.ar/");
        link.setPassword("meli1234");
        linkRepository.save(link); //no es bueno usar este metodo que estoy testeando
    }

    @Test
    public void testSaveWithCorrectLink(){
        //Arrange
        LinkDTO link = new LinkDTO();
        link.setLinkId(5);

        //Act
        LinkDTO currentLink = linkRepository.save(link);

        //Assert
        Assertions.assertEquals(5, currentLink.getLinkId());
    }

    @Test
    public void testWithLinkIdNull(){
        //Arrange
        LinkDTO linkDTO = new LinkDTO();

        //Act
        LinkDTO currentLink = linkRepository.save(linkDTO);

        //Assert
        Assertions.assertNotNull(currentLink.getLinkId());
    }

    @Test
    public void testFindLinkWithExistingLink(){
        //Arrange
        Integer linkid = 0;

        //Act
        Optional<LinkDTO> linkCurrent = linkRepository.findLinkByLinkId(linkid);

        //Assert
        Assertions.assertEquals(linkid, linkCurrent.get().getLinkId());
    }

    @Test
    public void testFindLinkWithNotFoundLink(){
        //Arrange
        Integer linkid = 12345;

        //Act
        Optional<LinkDTO> linkCurrent = linkRepository.findLinkByLinkId(linkid);

        //Assert
        Assertions.assertTrue(linkCurrent.isEmpty());
    }

    @Test
    public void testDeleteExistingLink(){
        //Arrange
        Integer id = 0;
        LinkDTO linkToDelete = new LinkDTO();
        linkToDelete.setLinkId(id);

        //Act
        linkRepository.delete(linkToDelete);
        Optional<LinkDTO> linkDeleted = linkRepository.findLinkByLinkId(id);

        //Assert
        Assertions.assertTrue(linkDeleted.isEmpty());
    }

}
