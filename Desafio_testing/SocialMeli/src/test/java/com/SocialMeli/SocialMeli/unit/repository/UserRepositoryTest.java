package com.SocialMeli.SocialMeli.unit.repository;

import com.SocialMeli.SocialMeli.entity.User;
import com.SocialMeli.SocialMeli.repository.IUserRepository;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class UserRepositoryTest {
    private static IUserRepository userRepository = new UserRepository();

    @Test
    void getUserSuccess(){
        //Arrange
        int id = 1;

        //Act
        User user = userRepository.getUser(id);

        //Assert
        Assertions.assertNotNull(user);
    }

    @Test
    void getUserNotFound(){
        //Arrange
        int id = 99;
        //Act
        User user = userRepository.getUser(id);

        //Assert
        Assertions.assertNull(user);
    }

    @Test
    void addFollowerSuccess(){
        //Arrange
        int sellerId = 3;
        int userId = 1;

        //Act
        boolean followed = userRepository.addFollower(userId, sellerId);

        //Assert
        Assertions.assertTrue(followed);
    }

    @Test
    void addFollowerThenCantCastToSellerClass(){
        //Arrange
        int sellerId = 1;
        int userId = 3;

        //Act & Assert
        Assertions.assertThrows(
                ClassCastException.class, ()->userRepository.addFollower(userId, sellerId)
        );
    }

    @Test
    void getFollowersSuccess(){
        //Arrange
        int sellerId = 3;

        //Act
        Map<Integer, User> followers = userRepository.getFollowers(sellerId);

        //Assert
        Assertions.assertNotNull(followers);
    }

    @Test
    void getFollowersThenCantCastToSellerClass(){
        //Arrange
        int sellerId = 1;

        //Act & Assert
        Assertions.assertThrows(
                ClassCastException.class, ()->userRepository.getFollowers(sellerId)
        );
    }

    @Test
    void getFollowedSuccess(){
        //Arrange
        int userId = 1;
        userRepository.addFollower(1,3);
        userRepository.addFollower(1,4);

        //Act
        Map<Integer, User> followed = userRepository.getFollowed(userId);

        //Assert
        Assertions.assertAll(
                ()->Assertions.assertNotNull(followed),
                ()->Assertions.assertEquals(2, followed.size())
        );
    }

    @Test
    void unfollowSellerSuccess(){
        //Arrange
        int userId = 1;
        int sellerId = 3;

        userRepository.addFollower(userId, sellerId);

        //Act
        boolean unfollow = userRepository.unFollowSeller(userId, sellerId);

        //Assert
        Assertions.assertTrue(unfollow);
    }

    @Test
    void unfollowSellerThenCantCastToSellerClass(){
        //Arrange
        int sellerId = 1;
        int userId = 3;

        //Act & Assert
        Assertions.assertThrows(
                ClassCastException.class, ()->userRepository.unFollowSeller(userId, sellerId)
        );
    }
}
