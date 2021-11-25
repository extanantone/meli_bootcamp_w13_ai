package com.mercadolibre.linktracker.repositories;

import com.mercadolibre.linktracker.dto.LinkDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LinkRepositoryImplTest {

    LinkRepositoryImpl repository;

    @BeforeEach
    private void clearDB() {
        repository = new LinkRepositoryImpl();
    }

    @Test
    void saveAndGetElement() {
        LinkDTO expected = new LinkDTO();

        LinkDTO actual = repository.save(expected);
        assertAll(
                () -> assertEquals(0, actual.getLinkId()),
                () -> assertTrue(repository.findLinkByLinkId(0).isPresent())
        );
    }

    @Test
    void getElementThatDoesntExist() {
        assertTrue(repository.findLinkByLinkId(0).isEmpty());
    }

    @Test
    void deleteElement() {
        LinkDTO testElement = new LinkDTO();
        testElement = repository.save(testElement);

        assertTrue(repository.findLinkByLinkId(0).isPresent());
        repository.delete(testElement);

        assertTrue(repository.findLinkByLinkId(0).isEmpty());
    }
}