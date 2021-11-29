package com.example.socialmeli.unit.service;

import com.example.socialmeli.Models.User;
import com.example.socialmeli.exceptions.OrderNoFound;
import com.example.socialmeli.repository.IUserRepository;

import com.example.socialmeli.services.ProductServices;

import com.example.socialmeli.unit.utils.UtilsProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServicesTest {

    @Mock
    IUserRepository mockRepository;

    @InjectMocks
    ProductServices service;


    @BeforeEach
    void zinit(){
        User.setNumberUser(0);
        UtilsProductService.cleanArrayOfProducts();

    }

    @AfterEach
    void after(){
        Mockito.reset(mockRepository);
    }

    @Test
    void CheckOrderByDateOfProducts(){
        Integer id = 2;

        when(mockRepository.getListProducts()).thenReturn(UtilsProductService.getArrayListOfProducts());
        when(mockRepository.getUserbyId(2)).thenReturn(UtilsProductService.getUser2());

        assertEquals("15-11-2021",service.getFeedProducts(id, "date_asc").getPosts().get(0).getDate());
        assertEquals("16-11-2021",service.getFeedProducts(id, "date_desc").getPosts().get(0).getDate());

    }

    @Test
    void CheckOrderByDateOfProductsWithUnknowParam(){
        Integer id = 2;

        when(mockRepository.getListProducts()).thenReturn(UtilsProductService.getArrayListOfProducts());
        when(mockRepository.getUserbyId(2)).thenReturn(UtilsProductService.getUser2());

       assertThrows(OrderNoFound.class,()-> service.getFeedProducts(2, "date_"));
       assertThrows(OrderNoFound.class, ()-> service.getFeedProducts(2, "deafas"));

    }

    @Test
    void GetOnlyProductOfLastTwoWeeks(){
        Integer id = 2;
        when(mockRepository.getListProducts()).thenReturn(UtilsProductService.getArrayListOfProducts());
        when(mockRepository.getUserbyId(id)).thenReturn(UtilsProductService.getUser2());
        System.out.println(service.getFeedProducts(id, "date_asc"));

        assertEquals(2, service.getFeedProducts(id, "date_asc").getPosts().size());
        assertEquals("15-11-2021", service.getFeedProducts(id, "date_asc").getPosts().get(0).getDate());

    }




}
