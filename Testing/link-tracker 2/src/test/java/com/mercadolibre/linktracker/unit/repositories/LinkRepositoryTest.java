package com.mercadolibre.linktracker.unit.repositories;

import com.mercadolibre.linktracker.unit.dto.LinkDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class LinkRepositoryTest
{

    LinkRepositoryImpl linkRepository = new LinkRepositoryImpl();

    @Test
    void saveCorrectlyAndReturnTheSameObject()
    {
        // Arrange
        LinkDTO linkDTO = new LinkDTO();
        // Act
        LinkDTO save = linkRepository.save(linkDTO);
        // Assert
        Assertions.assertEquals(save, linkDTO);
    }

    @Test
    void findLinkByLinkIdWhenLinkisSaved()
    {
        // Arrange
        LinkDTO linkDTO = new LinkDTO();
        linkRepository.save(linkDTO);
        Optional<LinkDTO> optionalLinkDTO = Optional.of(linkDTO);
        // Act
        Optional<LinkDTO> expected = linkRepository.findLinkByLinkId(linkDTO.getLinkId());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(expected.isPresent()),
                () -> Assertions.assertEquals(optionalLinkDTO, expected)
        );
    }

    @Test
    void findLinkByLinkIdWhenLinkisNotSaved()
    {
        // Arrange
        LinkDTO linkDTO = new LinkDTO();
        Optional<LinkDTO> optionalLinkDTO = Optional.of(linkDTO);
        // Act
        Optional<LinkDTO> expected = linkRepository.findLinkByLinkId(linkDTO.getLinkId());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertFalse(expected.isPresent()),
                () -> Assertions.assertNotEquals(optionalLinkDTO, expected)
        );
    }

    @Test
    void deleteWhenLinkIsSaved()
    {
        // Arrange
        LinkDTO linkDTO = new LinkDTO();
        Optional<LinkDTO> optionalLinkDTO = Optional.of(linkDTO);
        // Act
        linkRepository.delete(linkDTO);
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertFalse(linkRepository.findLinkByLinkId(linkDTO.getLinkId()).isPresent())
        );
    }

    void deleteWhenLinkIsNotSaved()
    {
        // Arrange
        LinkDTO linkDTO = new LinkDTO();
        Optional<LinkDTO> optionalLinkDTO = Optional.of(linkDTO);

        // Act
        linkRepository.delete(linkDTO);
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertFalse(linkRepository.findLinkByLinkId(linkDTO.getLinkId()).isPresent())
        );
    }
}