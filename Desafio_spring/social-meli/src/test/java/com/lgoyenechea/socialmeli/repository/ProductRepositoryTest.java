package com.lgoyenechea.socialmeli.repository;

import com.lgoyenechea.socialmeli.model.Post;
import com.lgoyenechea.socialmeli.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setDetail(new Product());
    }

    @Test
    void givenValidPost_whenSave_thenSavedOk() {
        productRepository.save(post);
        assertEquals(post.getId(), 1);
        assertEquals(post.getDetail().getId(), 1);
    }

    @Test
    void givenPostId_whenGetById_thenReturnPost() {
        productRepository.save(post);
        Post response = productRepository.getById(1L);
        assertEquals(post, response);
    }

    @Test
    void givenPostId_whenGetById_thenNull() {
        Post response = productRepository.getById(1L);
        assertNull(response);
    }

    @Test
    void givenCorrectUserId_whenGetByUserId_thenReturnPosts() {
        post.setUserId(1L);
        productRepository.save(post);
        List<Post> response = productRepository.getByUserId(1L);
        assertFalse(response.isEmpty());
        assertEquals(response.get(0), post);
    }
}