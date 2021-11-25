package com.SocialMeli.SocialMeli.unit.repository;

import com.SocialMeli.SocialMeli.entity.Post;
import com.SocialMeli.SocialMeli.entity.Product;
import com.SocialMeli.SocialMeli.repository.IPostRepository;
import com.SocialMeli.SocialMeli.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PostRepositoryTest {
    private static IPostRepository postRepository = new PostRepository();

    @BeforeAll
    static void createPost(){
        Post postCreate = new Post();
        postCreate.setId(1);
        postCreate.setDate(LocalDate.of(2021, 11, 25));
        postCreate.setSellerId(3);
        postCreate.setPrice(1000);
        postCreate.setCategory(1);
        Product product = new Product();
        product.setId(1);
        product.setName("Producto 1");
        product.setBrand("Brand 1");
        product.setColor("Negro");
        product.setType("Tipo");
        product.setNotes("");
        postCreate.setDetail(product);

        postRepository.create(postCreate);
    }

    @Test
    void createSuccess(){
        //Arrange
        Post postCreate = new Post();
        postCreate.setId(2);
        postCreate.setDate(LocalDate.of(2021, 11, 25));
        postCreate.setSellerId(3);
        postCreate.setPrice(1000);
        postCreate.setCategory(1);
        Product product = new Product();
        product.setId(2);
        product.setName("Producto 1");
        product.setBrand("Brand 1");
        product.setColor("Negro");
        product.setType("Tipo");
        product.setNotes("");
        postCreate.setDetail(product);

        Post postNotExists = postRepository.getById(postCreate.getId());

        //Act
        boolean created = postRepository.create(postCreate);
        Post postCreated = postRepository.getById(postCreate.getId());

        //Assert
        Assertions.assertNull(postNotExists);
        Assertions.assertTrue(created);
        Assertions.assertNotNull(postCreated);
    }

    @Test
    void getByIdSuccess(){
        //Arrange
        int id = 1;

        //Act
        Post postFind = postRepository.getById(id);

        //Assert
        Assertions.assertNotNull(postFind);
    }

    @Test
    void getByIdNotFound(){
        // Arrange
        int id = 2;

        // Act
        Post result = this.postRepository.getById(id);

        // Assert
        Assertions.assertNull(result);
    }

    @Test
    void getByUserIdSuccess(){
        //Arrange
        int userId = 3;
        LocalDate date = LocalDate.now().minus(Period.ofDays(14));

        //Act
        List<Post> postsByUser = postRepository.getByUserId(userId, date);

        //Assert
        Assertions.assertEquals(1, postsByUser.size());
    }

    @Test
    void getByUserIdNotFound(){
        //Arrange
        int userId = 99;
        LocalDate date = LocalDate.now().minus(Period.ofDays(14));

        //Act
        List<Post> postsByUser = postRepository.getByUserId(userId, date);

        //Assert
        Assertions.assertEquals(0, postsByUser.size());
    }
}
