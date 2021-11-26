package com.example.socialmeli.UnitTest.Service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IProductRepository;

import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private static User userId;

    private static List<PostCreateDto> posts;

    @InjectMocks
    ProductService service;

    @Mock
    IProductRepository prodRepository;

    @Mock
    IUserRepository userRepository;

    @BeforeAll
    public static void postContain() {
        userId = new User();
        userId.setUserId(1);
        userId.setUserName("Camilo_vendedor1");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Andres_vendedor2");

        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Pablo_vendedor3");

        userId.addFollowed(new UserDto(user2));
        userId.addFollowed(new UserDto(user3));


        PostCreateDto post1 = new PostCreateDto();
        post1.setIdPost(1);
        post1.setCategory(5);
        post1.setDate(LocalDate.of(2021,11,25));
        post1.setDetail(new ProductDto(
                1,
                "Cama grande",
                "gamer",
                "racer",
               "Red",
                "espaciosa sin grumos "
        ));
        post1.setPrice(10000D);
        post1.setUserId(user2.getUserId());

        PostCreateDto post2 = new PostCreateDto();
        post2.setIdPost(2);
        post2.setCategory(5);
        post2.setDate(LocalDate.of(2021,11,20));
        post2.setDetail(new ProductDto(
                1,
                "silla grande",
                "gamer",
                "racer",
                "Red",
                "espaciosa sin grumos "
        ));
        post2.setPrice(10000D);
        post2.setUserId(user3.getUserId());

        posts = List.of(post1,post2);

    }

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

    @Test
    @DisplayName("Validar ordenamiento de fecha ascendente")
    void test601() {

        String order = "date_asc";

        List<PostDto> postDto = posts.stream()
                .sorted(Comparator.comparing(PostCreateDto::getDate))
                .map(PostDto::new)
                .collect(Collectors.toList());

        testDatePost(postDto,order);
    }

    @Test
    @DisplayName("Validar ordenamiento de fecha descendente")
    void test602() {

        String order = "date_desc";

        List<PostDto> postDto = posts.stream()
                .sorted(Comparator.comparing(PostCreateDto::getDate).reversed())
                .map(PostDto::new)
                .collect(Collectors.toList());

        testDatePost(postDto,order);
    }




    void testDatePost(List<PostDto> postDto, String order) {

        Integer user2 = 2;
        Integer user3 = 3;


        PostsDto expected = new PostsDto(userId.getUserId(),postDto);

        Mockito.when(userRepository.findById(userId.getUserId())).thenReturn(Optional.of(userId));
        Mockito.when(prodRepository.listPosts(user2)).thenReturn(List.of(posts.get(0)));
        Mockito.when(prodRepository.listPosts(user3)).thenReturn(List.of(posts.get(1)));

        PostsDto current = service.listPosts(userId.getUserId(),order);

        Mockito.verify(userRepository,Mockito.atLeastOnce()).findById(userId.getUserId());
        Mockito.verify(prodRepository,Mockito.atLeast(2)).listPosts(Mockito.anyInt());

        Assertions.assertEquals(expected,current);
    }
}
