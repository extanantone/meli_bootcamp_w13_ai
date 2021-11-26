package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    //mock
    @Mock
    CharacterRepositoryImpl repo;

    //lo que quiero testear
    @InjectMocks
    FindService service;


}
