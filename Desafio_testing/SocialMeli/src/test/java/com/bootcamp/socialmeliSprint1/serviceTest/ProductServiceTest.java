package com.bootcamp.socialmeliSprint1.serviceTest;

import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;

import com.bootcamp.socialmeliSprint1.service.ProductServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ISocialMeliRepository mockRepository;

    @InjectMocks
    ProductServiceImpl productService;

    /***************************************************************************
     *
     * T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009)
     *
     **************************************************************************/





}
