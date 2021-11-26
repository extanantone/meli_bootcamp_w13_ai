package com.bootcamp.socialmeli.repository;


import com.bootcamp.socialmeli.DTO.DTOPublishPost;
import com.bootcamp.socialmeli.DTO.DTOUser;
import com.bootcamp.socialmeli.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPostTest {

    IPostRepository iPostRepository;

    @BeforeEach
    private void initialize(){
        this.iPostRepository= new PostRepository();
    }

    @Test
    void verifyPostOrderExistence(){

        //Arrange
        String order = null;

        List<DTOPublishPost> PostList = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2021,12,5);
        LocalDate date2 = LocalDate.of(2021,12,6);
        LocalDate date3 = LocalDate.of(2021,12,7);

        Product product = new Product(1,"Silla","Asiento","Marca","gris","prueba");

        PostList.add(new DTOPublishPost(1, date1, product, 1, 100.20));
        PostList.add(new DTOPublishPost(2, date2, product, 1, 100.20));
        PostList.add(new DTOPublishPost(3, date3, product, 1, 100.20));

        //Act and Assert
        Assertions.assertThrows(RuntimeException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                List<DTOPublishPost> response = iPostRepository.orderPosts(PostList,order);
            }
        });

    }
}
