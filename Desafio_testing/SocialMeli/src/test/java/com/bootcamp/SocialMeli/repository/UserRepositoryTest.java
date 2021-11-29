package com.bootcamp.SocialMeli.repository;


import com.bootcamp.SocialMeli.exceptions.UserNotFoundException;
import com.bootcamp.SocialMeli.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    UserRepository repository = new UserRepository();

    @Test
    void whenGetUserAndItExists() {

        //Arrange
        User expect = new User(1, "Juan");

        //Act
        User current = repository.getUser(expect.getUserId()).get();

        //Assert
        Assertions.assertEquals(expect, current);
    }

    @Test
    void whenGetUserAndNotExists() {
        //Arrange
        User expect = new User(5, "Nicolas");

        //Act & Assert
        Exception exception = Assertions.assertThrows(UserNotFoundException.class,
                () -> repository.getUser(expect.getUserId()));
    }

}
