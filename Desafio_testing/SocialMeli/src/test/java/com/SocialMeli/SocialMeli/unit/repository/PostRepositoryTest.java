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
        //Publicacion actual
        Post postCreate = new Post();
        postCreate.setId(1);
        postCreate.setDate(LocalDate.now());
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

        //Publicacion de mas de 2 semanas
        LocalDate twentyDaysAgo = LocalDate.now().minus(Period.ofDays(20));

        Post postCreate2 = new Post();
        postCreate2.setId(2);
        postCreate2.setDate(twentyDaysAgo);
        postCreate2.setSellerId(3);
        postCreate2.setPrice(1000);
        postCreate2.setCategory(1);
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Producto 2");
        product2.setBrand("Brand 2");
        product2.setColor("Negro");
        product2.setType("Tipo");
        product2.setNotes("");
        postCreate.setDetail(product2);

        postRepository.create(postCreate2);

        //Publicacion promo
        LocalDate today = LocalDate.now();

        Post promoCreate = new Post();
        promoCreate.setId(90);
        promoCreate.setDate(twentyDaysAgo);
        promoCreate.setSellerId(3);
        promoCreate.setPrice(1000);
        promoCreate.setCategory(1);
        Product productPromo = new Product();
        productPromo.setId(90);
        productPromo.setName("ProductoPromo");
        productPromo.setBrand("Brand");
        productPromo.setColor("Negro");
        productPromo.setType("Tipo");
        productPromo.setNotes("");
        promoCreate.setDetail(productPromo);

        postRepository.create(promoCreate);
    }

    @Test
    void createSuccess(){
        //Arrange
        LocalDate oneWeekAgo = LocalDate.now().minus(Period.ofDays(7));

        Post postCreate = new Post();
        postCreate.setId(3);
        postCreate.setDate(oneWeekAgo);
        postCreate.setSellerId(3);
        postCreate.setPrice(1000);
        postCreate.setCategory(1);
        Product product = new Product();
        product.setId(3);
        product.setName("Producto 3");
        product.setBrand("Brand 3");
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
        int id = 99;

        // Act
        Post result = this.postRepository.getById(id);

        // Assert
        Assertions.assertNull(result);
    }

    //-----------------T-0008-----------------
    @Test
    void getByUserIdTwoWeeksAgoSuccess(){
        //Arrange
        int userId = 3;
        LocalDate date = LocalDate.now().minus(Period.ofDays(14));

        //Act
        List<Post> postsByUser = postRepository.getByUserId(userId, date);

        //Assert
        Assertions.assertEquals(1, postsByUser.size());
    }
    //---------------------------------------

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

    @Test
    void getPromosByUserSuccess(){
        //Arrange
        int id = 3;

        //Act
        List<Post> postFind = postRepository.getPromosByUser(id);

        //Assert
        Assertions.assertNotNull(postFind);
    }
}
