package com.mercadolibre.linktracker.unit.service;

import com.mercadolibre.linktracker.unit.dto.LinkDTO;
import com.mercadolibre.linktracker.unit.repositories.LinkRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest
{
    @Mock
    LinkRepository linkRepository;

    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    void createWhenSuccesfullySaved()
    {
        // Arrange
        LinkDTO linkDTO = new LinkDTO();

        Mockito.when(linkRepository.save(linkDTO)).thenReturn(linkDTO);
        // Act
        LinkDTO expected = linkService.create(linkDTO);
        // Assert
        Assertions.assertEquals(linkDTO.getLinkId(), expected.getLinkId());
    }

    @Test
    void redirectWhenLinkIsFound()
    {
        LinkDTO linkDTO = new LinkDTO();

        Mockito.when(linkRepository.findLinkByLinkId(linkDTO.getLinkId())).thenReturn(Optional.of(linkDTO));
        // Act
        LinkDTO expected = linkService.redirect(linkDTO.getLinkId());
        // Assert
        Assertions.assertEquals(linkDTO.getLinkId(), expected.getLinkId());
    }

    @Test
    void redirectWhenLinkIsNotFound()
    {
        LinkDTO linkDTO = new LinkDTO();

        Mockito.when(linkRepository.findLinkByLinkId(linkDTO.getLinkId())).thenReturn(Optional.empty());
        // Act
        LinkDTO expected = linkService.redirect(linkDTO.getLinkId());
        // Assert
        Assertions.assertNull(expected);
    }

    @Test
    void redirectWithPasswordWhenNotMatch()
    {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setPassword("bootcamp");
        Mockito.when(linkRepository.findLinkByLinkId(linkDTO.getLinkId())).thenReturn(Optional.of(linkDTO));
        // Act
        LinkDTO expected = linkService.redirect(linkDTO.getLinkId(), "wrongPassword");
        // Assert
        Assertions.assertNull(expected);
    }

    @Test
    void redirectWithPasswordWhenMatch()
    {
        // Arrange
        LinkDTO expected = new LinkDTO();
        expected.setPassword("bootcamp");
        Mockito.when(linkRepository.findLinkByLinkId(expected.getLinkId())).thenReturn(Optional.of(expected));
        // Act
        LinkDTO result = linkService.redirect(expected.getLinkId(), expected.getPassword());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, result),
                () -> Assertions.assertEquals(1, result.getCount())
        );
    }
}