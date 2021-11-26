package com.meli.SocialMeli.unit.repository;

import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.reposity.IRepository;
import com.meli.SocialMeli.reposity.RepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryImplTest {

    IRepository repository;

    @BeforeEach
    private void setUp() {
        this.repository = new RepositoryImpl();
    }

    @Test
    public void verifyUserExistence(){
        //Arrange
        int userId = 1;
        int userIdToFollow = 3;

        //Act
        User userIdExpected = repository.findUser(userId);
        User userIdToFollowExpected = repository.findUser(userIdToFollow);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userIdExpected.getUserId(), userId),
                () -> Assertions.assertEquals(userIdToFollowExpected.getUserId(), userIdToFollow)
        );

    }

    @Test
    public void verifyUserNotExistence(){
        //Arrange
        int userId = 10;
        int userIdToFollow = 8;
        User userIdCurrent = null;
        User userIdToFollowCurrent = null;

        //Act
        User userIdExpected = repository.findUser(userId);
        User userIdToFollowExpected = repository.findUser(userIdToFollow);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(userIdExpected, userIdCurrent),
                () -> Assertions.assertEquals(userIdToFollowExpected, userIdToFollowCurrent)
        );
    }
}
