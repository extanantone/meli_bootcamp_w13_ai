package com.example.socialmeli.repository;

import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;
import com.example.socialmeli.unit.utils.UtilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RepositoryTest {

    RepositoryUser repository;

    @BeforeEach
    void beforeEach(){
       this.repository = new RepositoryUser();
    }


    @Test
    void checkUserExistByID(){
        User user = UtilRepository.getUser2();
       repository.getUsersList().put(user.getUserId(), user);
       User userObtained = repository.getUserbyId(user.getUserId());

       assertEquals(user.getUsername(), userObtained.getUsername());
       assertEquals(user.getUserId(), userObtained.getUserId());
    }

    @Test
    void checkUserNotExist(){

        Integer id = 99;
        User userFound = repository.getUserbyId(id);
        assertEquals(null, userFound);

    }

    @Test
    void createPost(){
        Product producto =  UtilRepository.getProduct1();
        repository.createPost(producto);

        assertEquals(1 ,repository.getListProducts().size());
    }

    @Test
    void PostwithIDThaCurrentlyExist(){
        Product producto =  UtilRepository.getProduct1();
        repository.createPost(producto);
        Product producto2 =  UtilRepository.getProduct1();

        assertEquals(null , repository.createPost(producto2));
        assertEquals(1 ,repository.getListProducts().size());

    }

}

