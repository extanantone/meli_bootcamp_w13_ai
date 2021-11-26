package com.example.socialmeli.UnitTest.Repository;

import com.example.socialmeli.dto.PostCreateDto;
import com.example.socialmeli.dto.ProductDto;
import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IProductRepository;
import com.example.socialmeli.repository.ProductRepository;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

public class ProductRepositoryTest {


    ProductRepository repository = new ProductRepository();


    private static List<PostCreateDto> posts;

    @BeforeAll
    public static void postContain() {


        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Andres_vendedor2");


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
                2,
                "silla grande",
                "gamer",
                "racer",
                "Red",
                "espaciosa sin grumos "
        ));
        post2.setPrice(10000D);
        post2.setUserId(user2.getUserId());

        PostCreateDto post3 = new PostCreateDto();
        post3.setIdPost(3);
        post3.setCategory(5);
        post3.setDate(LocalDate.of(2021,9,20));
        post3.setDetail(new ProductDto(
                3,
                "silla pequena",
                "gamer",
                "racer",
                "Red",
                "espaciosa sin grumos "
        ));
        post3.setPrice(10000D);
        post3.setUserId(user2.getUserId());

        posts = List.of(post1,post2,post3);

    }



    @Test
    @DisplayName("Validar publicaciones de las dos ultimas semanas")
    void test801() {

        Integer userId = 2;
        repository.setPostCreateDtos(posts);

        List<PostCreateDto> current = repository.listPosts(userId);



        Assertions.assertAll(
                () -> Assertions.assertEquals(2,current.size()),
                () -> Assertions.assertEquals(posts.get(0),current.get(0)),
                () -> Assertions.assertEquals(posts.get(1),current.get(1))
        );




    }
}
