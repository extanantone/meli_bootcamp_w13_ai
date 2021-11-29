package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.DetailDTO;
import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.entities.Detail;
import com.example.SocialMeli.entities.Post;
import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.exception.ProductAlreadyExistException;
import com.example.SocialMeli.repository.ProductRepository;
import com.example.SocialMeli.repository.UserRepository;
import com.example.SocialMeli.services.mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl service;

    Post post = new Post(8L, 2, LocalDate.now(), new Detail(), 1, 15);

    //T-0005
    /*
    When order = name_asc
    */
    @Test
    void testWithDateOrderAsc() {
        List<User> vendedores = List.of(new User(1, "ftagliero",List.of(1L,2L, 3L)));
        Post post1 = new Post(1L, 1, LocalDate.of(2021,11,28), new Detail(), 1, 12.99);
        Post post2 = new Post(2L, 1, LocalDate.of(2021,11,27), new Detail(), 1, 12.99);
        Post post3 = new Post(3L, 1, LocalDate.of(2021,11,26), new Detail(), 1, 12.99);
        List<PostDTO> expected = new ArrayList<>(List.of(
                new PostDTO(3, 1, LocalDate.of(2021,11,26), new DetailDTO(), 1, 12.99),
                new PostDTO(2, 1, LocalDate.of(2021,11,27), new DetailDTO(), 1, 12.99),
                new PostDTO(1, 1, LocalDate.of(2021,11,28), new DetailDTO(), 1, 12.99)
                ));
        when(userRepository.getFolloweds(1)).thenReturn(vendedores);
        when(productRepository.getById(1L)).thenReturn(post1);
        when(productRepository.getById(2L)).thenReturn(post2);
        when(productRepository.getById(3L)).thenReturn(post3);

        Assertions.assertEquals(expected, service.getSellerFollowed(1, "name_asc").get(0).getPosts());


    }

    //T-0006
    /*
    When order = name_desc
     */
    @Test
    void testWithDateOrderDesc() {
        List<User> vendedores = List.of(new User(1, "ftagliero",List.of(1L,2L, 3L)));
        Post post1 = new Post(1L, 1, LocalDate.of(2021,11,26), new Detail(), 1, 12.99);
        Post post2 = new Post(2L, 1, LocalDate.of(2021,11,27), new Detail(), 1, 12.99);
        Post post3 = new Post(3L, 1, LocalDate.of(2021,11,28), new Detail(), 1, 12.99);
        List<PostDTO> expected = new ArrayList<>(List.of(
                new PostDTO(3, 1, LocalDate.of(2021,11,28), new DetailDTO(), 1, 12.99),
                new PostDTO(2, 1, LocalDate.of(2021,11,27), new DetailDTO(), 1, 12.99),
                new PostDTO(1, 1, LocalDate.of(2021,11,26), new DetailDTO(), 1, 12.99)
        ));
        when(userRepository.getFolloweds(1)).thenReturn(vendedores);
        when(productRepository.getById(1L)).thenReturn(post1);
        when(productRepository.getById(2L)).thenReturn(post2);
        when(productRepository.getById(3L)).thenReturn(post3);

        Assertions.assertEquals(expected, service.getSellerFollowed(1, "name_desc").get(0).getPosts());
    }

    /*
    Test when post doesnt exist then the post is saved .
     */
    @Test
    void testSavePost() {
        when(productRepository.getById(8L)).thenReturn(null);
        when(userRepository.savePost(8,2)).thenReturn(true);
        when(productRepository.saveProduct(post)).thenReturn(true);
        Assertions.assertDoesNotThrow(() -> service.saveProduct(ProductMapper.toDto(post)));
    }

    /*
    Test save post when post already exist then throw PostAlreadyExistException.
     */
    @Test
    void testSavePostWhenPostAlreadyExist() {
        when(productRepository.getById(8L)).thenReturn(post);
        Assertions.assertThrows(ProductAlreadyExistException.class, () -> service.saveProduct(ProductMapper.toDto(post)));
    }

}