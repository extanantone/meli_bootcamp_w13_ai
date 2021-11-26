package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.repositorios.IRepositorios;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicioUsuariosTest {

    @Mock
    private IRepositorios mockRepo;

    @InjectMocks
    private ServicioUsuarios servicio;

}
