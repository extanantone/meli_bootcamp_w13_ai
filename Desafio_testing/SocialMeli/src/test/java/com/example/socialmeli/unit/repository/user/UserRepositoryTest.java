package com.example.socialmeli.unit.repository.user;

import com.example.socialmeli.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserRepositoryTest
{

    UserRepository userRepository = null;

    User user1 = null;
    User user2 = null;
    User user3 = null;
    User user4 = null;

    @BeforeEach
    void setUp()
    {
        userRepository = new UserRepository();
        user1 = userRepository.getUserList().get(0);
        user2 = userRepository.getUserList().get(1);
        user3 = userRepository.getUserList().get(2);
        user4 = userRepository.getUserList().get(3);
        user1.follow(user2);
        user1.follow(user3);
        user1.follow(user4);

        user2.follow(user1);
        user3.follow(user1);
        user4.follow(user1);
    }

    //T-0004
    //Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    @Test
    void findFollowersOrderByNameDesc()
    {
        // Arrange
        List<User> expected = List.of(user4, user3, user2);
        // Act
        List<User> result = userRepository.findFollowersOrderByNameDesc(user1.getUserId());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, result.size()),
                () -> Assertions.assertEquals(expected, result)
        );
    }

    @Test
    void findFollowersOrderByNameAsc()
    {
        // Arrange
        List<User> expected = List.of(user2, user3, user4);
        // Act
        List<User> result = userRepository.findFollowersOrderByNameAsc(user1.getUserId());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, result.size()),
                () -> Assertions.assertEquals(expected, result)
        );
    }

    @Test
    void findFollowedOrderByNameDesc()
    {
        // Arrange
        List<User> expected = List.of(user4, user3, user2);
        // Act
        List<User> result = userRepository.findFollowedOrderByNameDesc(user1.getUserId());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, result.size()),
                () -> Assertions.assertEquals(expected, result)
        );
    }

    @Test
    void findFollowedOrderByNameAsc()
    {
        // Arrange
        List<User> expected = List.of(user2, user3, user4);
        // Act
        List<User> result = userRepository.findFollowedOrderByNameAsc(user1.getUserId());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, result.size()),
                () -> Assertions.assertEquals(expected, result)
        );
    }
}