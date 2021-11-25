package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {

    @Mock
    LinkRepository repository;

    @InjectMocks
    LinkServiceImpl service;

    private LinkDTO testElement;

    @BeforeEach
    void setUp() {
        testElement = new LinkDTO();
        testElement.setLinkId(1);
        testElement.setCount(2);
        testElement.setLink("www.test.com");
        testElement.setPassword("pass");
    }

    @Test
    void checkIncorrectPassword() {
        LinkDTO actual;
        Mockito.when(repository.findLinkByLinkId(testElement.getLinkId())).thenReturn(Optional.of(testElement));
        try {
            actual = service.redirect(testElement.getLinkId(), "incorrect");
        } catch (NullPointerException e) {
            actual = null;
        }
        assertNull(actual);
    }

    @Test
    void redirectAndCheckCount() {
        int expectedCount = 3;
        String expectedRedirect = testElement.getLink();

        Mockito.when(repository.findLinkByLinkId(testElement.getLinkId())).thenReturn(Optional.of(testElement));
        String actualRedirect = service.redirect(testElement.getLinkId(), testElement.getPassword()).getLink();
        int actualCount = service.metrics(testElement.getLinkId()).getCount();
        assertAll(
                () -> assertEquals(expectedRedirect, actualRedirect),
                () -> assertEquals(expectedCount, actualCount)
        );
    }
}