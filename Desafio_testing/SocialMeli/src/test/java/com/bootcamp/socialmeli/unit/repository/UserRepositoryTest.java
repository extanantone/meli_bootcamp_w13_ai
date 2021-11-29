package com.bootcamp.socialmeli.unit.repository;

import com.bootcamp.socialmeli.exception.NotFoundUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.UserRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class UserRepositoryTest {

    static UserRepository userRepository = new UserRepository();
    static User userTest;
    static User userFollowedTest;

    @BeforeAll
    @DisplayName("Obtengo dos usuarios para poder realizar los test")
    public static void initializingVariablesForTesting(){
        userTest = userRepository.createUser("comprador");
        userFollowedTest = userRepository.createUser("vendedor");
    }

    @BeforeEach
    @DisplayName("Reseteo los usuarios (elimino seguidores y seguidos, y post realizados")
    void resetVariablesForTesting(){
        //Reseteo los usuarios seguidos del usuario comprador
        userTest.removeAllFollowed();
        //Reseteo seguidores del usuario vendedor
        userFollowedTest.removeAllFollower();
    }

    @Test
    void shouldGetValidUser() throws NotPossibleOperationException{
        //Arrange
        User currentUser;
        User currentUserFollowed;
        //Act
        currentUser = userRepository.getUser(userTest.getId());
        currentUserFollowed = userRepository.getUser(userFollowedTest.getId());
        //Assert
        Assertions.assertEquals(userTest, currentUser);
        Assertions.assertEquals(userFollowedTest, currentUserFollowed);
    }

    @Test
    void shouldThrowExceptionWhenGetInvalidUserId() throws NotPossibleOperationException{
        //Arrange
        int invalidId = -999;
        //Act & Assert
        Assertions.assertThrows(NotFoundUserException.class, () -> userRepository.getUser(invalidId));
    }


    @Test
    @DisplayName("Verifica que se pueda realizar un follow de un usuario con ID valido")
    void shouldFollowValidUserId() throws NotPossibleOperationException {
        //Act
        userRepository.followUser(userTest, userFollowedTest);
        //Assert
        Assertions.assertTrue(
                userTest.getFollowedUserId().contains(userFollowedTest.getId())
                && userFollowedTest.getFollowersUserId().contains(userTest.getId())
        );
    }


    @Test
    void shouldNotFollowInvalidUserId(){
        //Act && Assert
        Assertions.assertThrows(NotPossibleOperationException.class, () -> userRepository.followUser(userTest, null));
    }

    @Test
    void shouldNotFollowSameUserId(){
        //Act && Assert
        Assertions.assertThrows(NotPossibleOperationException.class, () -> userRepository.followUser(userTest, userTest));
    }

    @Test
    void shouldUnfollowValidUserId() throws NotPossibleOperationException{
        //Arrange
        userRepository.followUser(userTest, userFollowedTest);
        //Act
        userRepository.unfollowUser(userTest, userFollowedTest);
        //Assert
        Assertions.assertFalse(
                userTest.getFollowedUserId().contains(userFollowedTest.getId())
                        && userFollowedTest.getFollowersUserId().contains(userTest.getId())
        );
    }

    @Test
    void shouldNotUnfollowValidUserId(){
        //Act && Assert
        Assertions.assertThrows(NotPossibleOperationException.class, () -> userRepository.unfollowUser(userTest, null));
    }

    @Test
    void shouldNotUnfollowSameValidUserId(){
        //Act && Assert
        Assertions.assertThrows(NotPossibleOperationException.class, () -> userRepository.unfollowUser(userTest, userTest));
    }

    @Test
    void shouldReturnTotalUserFollowers() throws NotPossibleOperationException {
        //Arrange
        for (int i = 1; i <= 10; i++)   userFollowedTest.addFollower(i);
        int totalFollowersExpected = 10;
        //Act
        int totalFollowersCurrent = userRepository.getTotalUserFollowers(userFollowedTest);
        //Assert
        Assertions.assertEquals(totalFollowersExpected, totalFollowersCurrent);
    }

    @Test
    void shouldNotReturnTotalUserFollowers() throws NotPossibleOperationException {
        //Arrange
        int totalFollowersExpected = 1;
        userFollowedTest.addFollowed(1);
        //Act
        int totalFollowersCurrent = userRepository.getTotalUserFollowers(userFollowedTest);
        //Assert
        Assertions.assertNotEquals(totalFollowersExpected, totalFollowersCurrent);
    }

    @Test
    void shouldThrowExceptionWhenGetTotalUserFollowers() throws NotPossibleOperationException {
        //Arrange
        User invalidUser = null;
        //Act & Assert
        Assertions.assertThrows(NotFoundUserException.class, () -> userRepository.getTotalUserFollowers(invalidUser));
    }

    @Test
    void shouldThrowExceptionWhenGetUserFollowers() throws NotPossibleOperationException {

        //Arrange
        int invalidId = -999;
        //Act & Assert
        Assertions.assertThrows(NotFoundUserException.class, () -> userRepository.getUsersFollowers(invalidId));
    }
}
