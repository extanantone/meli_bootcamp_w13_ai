package com.bootcamp.socialmeli.unit.repository;

import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductRespositoryTest {

    static List<Post> postList = new ArrayList<>();
    static ProductRepository productRepository = new ProductRepository();
    static Product productTest;
    static Product productTest2;
    static Product productTest3;
    static Post postTest;
    static Post postTest2;
    static Post postTest3;
    static LocalDate dateTest = LocalDate.of(2021, 11, 15);;

    @BeforeAll
    public static void initializingVariablesForTesting(){

        productTest = new Product(
                1,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red Black",
                "Special Edition"
        );
        productTest2 = new Product(
                4,
                "Teclado Gamer",
                "Gamer",
                "Logitech",
                "Plate",
                "Hardcore Edition"
        );

        productTest3 = new Product(
                5,
                "Mouse Gamer",
                "Gamer",
                "Logitech",
                "Black",
                "Hardcore Edition"
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        postTest = new Post(
                18,
                LocalDate.parse("01-11-2021", formatter),
                10000,
                123,
                3,
                productTest
        );

        postTest2 = new Post(
                20,
                LocalDate.parse("05-11-2021", formatter),
                500,
                456,
                4,
                productTest2
        );

        postTest3 = new Post(
                25,
                LocalDate.parse("05-09-2021", formatter),
                200,
                789,
                4,
                productTest3
        );
        productRepository.postProduct(postTest);
        productRepository.postProduct(postTest2);
        productRepository.postProduct(postTest3);


    }

    @Test
    void shouldReturnPostWithDateCheck(){
        //Arrange
        int userId = 4;
        List<Post> current;
        //Act
        current = productRepository.getPost(userId);

        //Assert
        Assertions.assertTrue(current.stream()
                .allMatch(p ->
                        p.getDate().isEqual(dateTest.minusWeeks(2))
                                || p.getDate().isAfter(dateTest.minusWeeks(2))
                ));

    }

}
