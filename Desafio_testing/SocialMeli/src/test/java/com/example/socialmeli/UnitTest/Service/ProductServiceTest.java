package com.example.socialmeli.UnitTest.Service;

import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.repository.IProductRepository;

import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService service;

    @Mock
    IProductRepository prodRepository;

    @Mock
    IUserRepository userRepository;

    @Test
    @DisplayName("Verificar ordenamiento de fecha (Exception)")
    void test501() {
        Integer userId = 1;
        String order = "date_noValid";

        Assertions.assertThrows(BadRequestException.class,
                () -> service.listPosts(1,order)
        );

        Mockito.verify(prodRepository,Mockito.never()).listPosts(userId);
        Mockito.verify(userRepository,Mockito.never()).findById(userId);



    }
}
