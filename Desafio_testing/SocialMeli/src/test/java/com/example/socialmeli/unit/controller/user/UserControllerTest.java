package com.example.socialmeli.unit.controller.user;

import com.example.socialmeli.controller.user.UserController;
import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.dto.user.FollowerCountDTO;
import com.example.socialmeli.dto.user.FollowerListDTO;
import com.example.socialmeli.service.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserControllerTest
{

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Test
    void followed()
    {
        // Arrange
        FollowedListDTO expected = new FollowedListDTO();
        // Act & Mock
        Mockito.when(userService.followed(1, null)).thenReturn(expected);
        FollowedListDTO result = userController.followed(1, null);
        // Assert
        Mockito.verify(userService, Mockito.atLeastOnce()).followed(1, null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void followers()
    {
        // Arrange
        FollowerListDTO expected = new FollowerListDTO();
        // Act & Mock
        Mockito.when(userService.followers(1, null)).thenReturn(expected);
        FollowerListDTO result = userController.followers(1, null);
        // Assert
        Mockito.verify(userService, Mockito.atLeastOnce()).followers(1, null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void countFollowers()
    {
        // Arrange
        FollowerCountDTO expected = new FollowerCountDTO();
        // Act & Mock
        Mockito.when(userService.countFollowers(1)).thenReturn(expected);
        FollowerCountDTO result = userController.countFollowers(1);
        // Assert
        Mockito.verify(userService, Mockito.atLeastOnce()).countFollowers(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void follow()
    {
        // Arrange
        FollowedListDTO expected = new FollowedListDTO();
        // Act & Mock
        Mockito.when(userService.follow(1, 2)).thenReturn(expected);
        FollowedListDTO result = userController.follow(1, 2);
        // Assert
        Mockito.verify(userService, Mockito.atLeastOnce()).follow(1, 2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void unfollow()
    {
        // Arrange
        FollowedListDTO expected = new FollowedListDTO();
        // Act & Mock
        Mockito.when(userService.unfollow(1, 2)).thenReturn(expected);
        FollowedListDTO result = userController.unfollow(1, 2);
        // Assert
        Mockito.verify(userService, Mockito.atLeastOnce()).unfollow(1, 2);
        Assertions.assertEquals(expected, result);
    }
}