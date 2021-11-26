package com.mercadolibre.linktracker;


import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.repositories.LinkRepository;
import com.mercadolibre.linktracker.repositories.LinkRepositoryImpl;
import com.mercadolibre.linktracker.service.LinkService;
import com.mercadolibre.linktracker.service.LinkServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LinkServiceImplTest {

    @Mock
    LinkRepository repo;

    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    @DisplayName("when id not exist in invalid method")
    void test1() {

        Integer linkeId = 90;


        Mockito.when(repo.findLinkByLinkId(linkeId)).thenReturn(Optional.empty());

        linkService.invalidate(linkeId);

        Mockito.verify(repo,Mockito.times(1)).findLinkByLinkId(linkeId);
        Mockito.verify(repo,Mockito.never()).delete(Mockito.any(LinkDTO.class));

    }
}
