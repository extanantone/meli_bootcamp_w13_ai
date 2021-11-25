package com.mercadolibre.linktracker.repositories;

import com.mercadolibre.linktracker.dto.LinkDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LinkRepositoryImplTest {

    LinkRepository linkRepository;

    static LinkDTO linkDTOtoTest = new LinkDTO();

    @BeforeAll
    public static void setUp(){
        linkDTOtoTest.setLinkId(4);
        linkDTOtoTest.setLink("www.github.com");
        linkDTOtoTest.setCount(0);
        linkDTOtoTest.setPassword("perro");
    }

    @BeforeEach
    public void beforeEach(){
        linkRepository = new LinkRepositoryImpl();

        LinkDTO linkDTO1 = new LinkDTO();
        linkDTO1.setLinkId(2);
        linkDTO1.setLink("www.google.com");
        linkDTO1.setCount(4);
        linkDTO1.setPassword("gato");

        LinkDTO linkDTO2 = new LinkDTO();
        linkDTO2.setLinkId(1);
        linkDTO2.setLink("www.workplace.com");
        linkDTO2.setCount(1);
        linkDTO2.setPassword("4123");

        linkRepository.save(linkDTO1);
        linkRepository.save(linkDTO2);
    }

    @Test
    void save() {
        Optional<LinkDTO> optionalLinkDtoNotFound = linkRepository.findLinkByLinkId(linkDTOtoTest.getLinkId());
        LinkDTO linkDTOSaved = linkRepository.save(linkDTOtoTest);
        Optional<LinkDTO> optionalLinkDto = linkRepository.findLinkByLinkId(linkDTOtoTest.getLinkId());

        assertFalse(optionalLinkDtoNotFound.isPresent());
        assertNotNull(linkDTOSaved);
        assertTrue(optionalLinkDto.isPresent());
    }

    @Test
    void findLinkByLinkId() {
        Optional<LinkDTO> optionalLinkDto = linkRepository.findLinkByLinkId(1);
        assertTrue(optionalLinkDto.isPresent());
        assertEquals("www.workplace.com", optionalLinkDto.get().getLink());

    }

    @Test
    void delete() {
        Optional<LinkDTO> optionalLinkDtoNotFounded = linkRepository.findLinkByLinkId(1);
        LinkDTO linkDTOToDelete = new LinkDTO();
        linkDTOToDelete.setLinkId(1);
        linkRepository.delete(linkDTOToDelete);
        Optional<LinkDTO> optionalLinkDto = linkRepository.findLinkByLinkId(1);

        assertTrue(optionalLinkDtoNotFounded.isPresent());
        assertFalse(optionalLinkDto.isPresent());
    }
}