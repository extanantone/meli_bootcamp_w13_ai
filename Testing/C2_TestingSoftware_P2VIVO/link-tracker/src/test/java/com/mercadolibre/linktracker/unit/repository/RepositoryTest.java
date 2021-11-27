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
        link.setLink("www.google.com");
        linkRepository.save(link);
    }

    //public LinkDTO save(LinkDTO link) {
    @Test
    public void testSaveWithCorrectLink(){


        //Arrange
        LinkDTO link = new LinkDTO();

        //Act
        LinkDTO currentLink = linkRepository.save(link);

        //Asserts
        Assertions.assertEquals(1,currentLink.getLinkId());
    }

    //public Optional<LinkDTO> findLinkByLinkId(Integer linkId) {
    @Test
    public void testFindLinkWithCorrectLink(){
        //Arrange
        Integer linkid = 0;


        //Act
        Optional<LinkDTO> linkCurrent = linkRepository.findLinkByLinkId(linkid);

        //Asserts
        Assertions.assertEquals(linkid,linkCurrent.get().getLinkId());
    }

    @Test
    public void testFindLinkWithIncorrectLink(){
        //Arrange
        Integer linkid = 2;


        //Act
        Optional<LinkDTO> linkCurrent = linkRepository.findLinkByLinkId(linkid);

        //Asserts
        Assertions.assertTrue(linkCurrent.isEmpty());
    }
}
