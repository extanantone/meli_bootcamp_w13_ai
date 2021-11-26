package com.bootcamp.SocialMeli.unit.repository.publicacion;

import com.bootcamp.SocialMeli.repository.publicacion.IPublicacionRepository;
import com.bootcamp.SocialMeli.service.publicacion.PublicacionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PublicacionServiceTests {
    @Mock
    IPublicacionRepository repository;

    @InjectMocks
    PublicacionService service;

    @Test
    public void checkDateSort(){

    }
}
