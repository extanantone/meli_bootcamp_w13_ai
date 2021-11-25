package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {

    @Mock
    LinkRepositoryImpl repository;

    @InjectMocks
    LinkServiceImpl service;

    static LinkDTO linkDTOtoTest = new LinkDTO();
    LinkDTO linkDTOtoReturn = new LinkDTO();


    @BeforeAll
    public static void setUp(){
        linkDTOtoTest.setLinkId(4);
        linkDTOtoTest.setLink("www.github.com");
        linkDTOtoTest.setCount(1);
        linkDTOtoTest.setPassword("perro");
    }

    @BeforeEach
    public void beforeEach(){
        linkDTOtoReturn.setLinkId(linkDTOtoTest.getLinkId());
        linkDTOtoReturn.setLink(linkDTOtoTest.getLink());
        linkDTOtoReturn.setPassword(linkDTOtoTest.getPassword());
        linkDTOtoReturn.setCount(linkDTOtoTest.getCount());
    }

    @Test
    void create() {
        Mockito.when(repository.save(linkDTOtoTest)).thenReturn(linkDTOtoTest);
        LinkDTO linkDTO = service.create(linkDTOtoTest);

        assertEquals(linkDTOtoTest, linkDTO);
    }

    @Test
    void redirectExistingLinkWithoutPassword() {
        Mockito.when(repository.findLinkByLinkId(linkDTOtoTest.getLinkId())).thenReturn(Optional.of(linkDTOtoReturn));
        LinkDTO linkDTO = service.redirect(linkDTOtoTest.getLinkId());

        assertNotNull(linkDTO);
        assertEquals(linkDTOtoTest.getCount() + 1,  linkDTO.getCount());
        assertEquals(linkDTOtoTest.getLink(),  linkDTO.getLink());
        assertEquals(linkDTOtoTest.getPassword(),  linkDTO.getPassword());
        assertEquals(linkDTOtoTest.getLinkId(),  linkDTO.getLinkId());
    }

    @Test
    void redirectNotExistingLinkWithoutPassword() {
        Mockito.when(repository.findLinkByLinkId(3)).thenReturn(Optional.empty());
        LinkDTO linkDTO = service.redirect(3);

        assertNull(linkDTO);
    }

    @Test
    void redirectExistingLinkWithCorrectPassword() {
        Mockito.when(repository.findLinkByLinkId(linkDTOtoTest.getLinkId())).thenReturn(Optional.of(linkDTOtoReturn));
        LinkDTO linkDTO = service.redirect(linkDTOtoTest.getLinkId(), linkDTOtoTest.getPassword());

        assertNotNull(linkDTO);
        assertEquals(linkDTOtoTest.getCount() + 1,  linkDTO.getCount());
        assertEquals(linkDTOtoTest.getLink(),  linkDTO.getLink());
        assertEquals(linkDTOtoTest.getPassword(),  linkDTO.getPassword());
        assertEquals(linkDTOtoTest.getLinkId(),  linkDTO.getLinkId());
    }

    @Test
    void redirectExistingLinkWithIncorrectPassword() {
        Mockito.when(repository.findLinkByLinkId(linkDTOtoTest.getLinkId())).thenReturn(Optional.of(linkDTOtoReturn));
        LinkDTO linkDTO = service.redirect(linkDTOtoTest.getLinkId(), linkDTOtoTest.getPassword() + "sadas");

        assertNull(linkDTO);
    }

    @Test
    void metricsExistingLink() {
        Mockito.when(repository.findLinkByLinkId(linkDTOtoTest.getLinkId())).thenReturn(Optional.of(linkDTOtoReturn));
        LinkDTO linkDTO = service.metrics(linkDTOtoTest.getLinkId());

        assertNotNull(linkDTO);
        assertEquals(linkDTOtoTest.getCount(),  linkDTO.getCount());
        assertEquals(linkDTOtoTest.getLink(),  linkDTO.getLink());
        assertEquals(linkDTOtoTest.getPassword(),  linkDTO.getPassword());
        assertEquals(linkDTOtoTest.getLinkId(),  linkDTO.getLinkId());
    }

    @Test
    void metricsNotExistingLink() {
        Mockito.when(repository.findLinkByLinkId(3)).thenReturn(Optional.empty());
        LinkDTO linkDTO = service.metrics(3);

        assertNull(linkDTO);
    }

}