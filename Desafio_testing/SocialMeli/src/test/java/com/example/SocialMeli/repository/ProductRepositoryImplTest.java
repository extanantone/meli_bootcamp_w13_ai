package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.Detail;
import com.example.SocialMeli.entities.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class ProductRepositoryImplTest {

    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        this.productRepository = new ProductRepositoryImpl();
    }

    @Test
    void saveProduct() {
        Post post = new Post(1L, 1, LocalDate.of(2021,11,27), new Detail(), 1,12.99);

        assertAll(
                () -> assertTrue(productRepository.saveProduct(post)),
                () -> assertEquals(post, productRepository.getById(1L))
        );
    }

    @Test
    void getById() {
        Post post = new Post(1L, 1, LocalDate.of(2021,11,27), new Detail(), 1,12.99);
        productRepository.saveProduct(post);
        assertAll(
                () -> assertEquals(post, productRepository.getById(1L))
        );
    }
}