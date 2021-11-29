package com.mercadolibre.linktracker.unitary.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class LinkRepositoryTest {

    LinkRepository repo;

    @BeforeEach
    private void initialize(){
        this.repo= new LinkRepositoryImpl();
    }

    @Test
    public void save(){
        //Arrange
        LinkDTO expected= new LinkDTO(1, "www.mercadolibre.com", "123987", 0);

        //Act
        LinkDTO response= repo.save(expected);

        //Assert
        Assertions.assertEquals(expected.getLinkId(), response.getLinkId());
    }

    @Test
    public void findLinkByLinkId(){
        //Arrange
        LinkDTO link1= new LinkDTO(1, "www.mercadolibre.com", "123987", 0);
        LinkDTO link2= new LinkDTO(2, "www.mercadolibre.com", "12", 0);
        LinkDTO link3= new LinkDTO(3, "www.mercadolibre.com", "23", 0);

        //Act
        LinkDTO response1= repo.save(link1);
        LinkDTO response2= repo.save(link2);
        LinkDTO response3= repo.save(link3);

        Optional<LinkDTO> response= repo.findLinkByLinkId(link2.getLinkId());

        //Assert
        Assertions.assertTrue(response.get().getLinkId().equals(link2.getLinkId()));
    }

    @Test
    public void delete(){
        //Arrange
        LinkDTO link1= new LinkDTO(1, "www.mercadolibre.com", "123987", 0);
        LinkDTO link2= new LinkDTO(2, "www.mercadolibre.com", "123987", 0);

        //Act
        LinkDTO response1= repo.save(link1);
        LinkDTO response2= repo.save(link2);
        repo.delete(link2);

        //Assert
        Optional<LinkDTO> response= repo.findLinkByLinkId(link2.getLinkId());
        Assertions.assertFalse(response.isPresent());
    }
}
