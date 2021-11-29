package com.bootcamp.SocialMeli.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.bootcamp.SocialMeli.entity.Buyer;
import com.bootcamp.SocialMeli.entity.Seller;
import com.bootcamp.SocialMeli.exception.ExceptionAlreadyFollows;
import com.bootcamp.SocialMeli.exception.ExceptionBuyerNotExist;
import com.bootcamp.SocialMeli.exception.ExceptionSellerNotExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SocialMeliRepositoryTest {

    Buyer user1, user2;
    Seller user3, user4;
    List<Buyer> buyers = new ArrayList<>();
    List<Seller> sellers = new ArrayList<>();

    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @BeforeEach
    public void setUp(){
        user1 = new Buyer(1,"Leon Comprador");
        user2 = new Buyer(2,"Juan Comprador");
        user3 = new Seller(3,"Manuel Vendedor");
        user4 = new Seller(4,"Pedro Vendedor");
        buyers.add(user1);
        buyers.add(user2);
        sellers.add(user3);
        sellers.add(user4);
    }

    @Test
    void findSellerByIdExistTest(){
        int userId = 3;
        assertDoesNotThrow(() -> userRepository.findSellerById(userId));
    }

    @Test
    void findSellerByIdNotExistTest(){
        int userId = 5;
        assertThrows(ExceptionSellerNotExist.class,
                ()->userRepository.findSellerById(userId), "Vendedor no existe");
    }
    @Test
    void findBuyerByIdExistTest(){
        int userId = 1;
        assertDoesNotThrow(() -> userRepository.findBuyerById(userId));
    }

    @Test
    void findBuyerByIdNotExistTest(){
        int userId = 6;
        assertThrows(ExceptionBuyerNotExist.class,
                ()->userRepository.findBuyerById(userId), "Comprador no existe");
    }
    @Test
    void followTest(){
        assertDoesNotThrow(()->userRepository.follow(user1,user4));

    }
    @Test
    void followAlreadyFollowTest(){

        user1.getFollowed().add(user3);
        user3.getFollowers().add(user1);

        assertThrows(ExceptionAlreadyFollows.class,
                ()->userRepository.follow(user1,user3), "Ya sigue al usuario vendedor");
    }

    @Test
    void unFollowTest(){
        user1.getFollowed().add(user4);
        user4.getFollowers().add(user1);

        assertTrue(userRepository.unFollow(user1,user4));
    }
    @Test
    void unFollowNotExistTest(){
        assertFalse(userRepository.unFollow(user1,user3));
    }
}

