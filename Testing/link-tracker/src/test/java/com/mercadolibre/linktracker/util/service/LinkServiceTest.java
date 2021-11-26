package com.mercadolibre.linktracker.util.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.service.LinkService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LinkServiceTest {
    //mock
    @Mock
    LinkRepositoryImpl repo;

    //lo que quiero testear
    @InjectMocks
    LinkService service;

    @Test
    void errorToRedirec(){
        LinkDTO link = new LinkDTO();

        Mockito
    }
}
