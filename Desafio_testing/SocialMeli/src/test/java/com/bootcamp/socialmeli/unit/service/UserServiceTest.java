package com.bootcamp.socialmeli.unit.service;

import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    static User userTest;
    static User userFollowedTest;

    @BeforeAll
    public static void initializingVariablesForTesting(){
        userTest = new User(1, "Nico");
        userFollowedTest = new User(3, "Pedro");
    }

    @Test
    void shouldNotThrowExceptionWhenFollowValidUser() throws NotPossibleOperationException {
        //Arrange
        int userId = 1;
        int userFollowedId = 3;
        Mockito.when(userRepository.getUser(userId)).thenReturn(userTest);
        Mockito.when(userRepository.getUser(userFollowedId)).thenReturn(userFollowedTest);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> userService.followUser(userId, userFollowedId));
    }

    @Test
    void shouldThrowExceptionWhenFollowValidUser() throws NotPossibleOperationException {
        //Arrange

        Mockito.when(userRepository.getUser(Mockito.anyInt())).thenThrow(NotPossibleOperationException.class);
        Mockito.when(userRepository.getUser(Mockito.anyInt())).thenThrow(NotPossibleOperationException.class);

        //Act & Assert
        Assertions.assertThrows(NotPossibleOperationException.class,() -> userService.followUser(Mockito.anyInt(), Mockito.anyInt()));
    }




}
