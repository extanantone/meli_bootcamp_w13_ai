package com.example.socialmeli.unit.controller;

import com.example.socialmeli.TestUtilsGenerator;
import com.example.socialmeli.controllers.UsersController;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTests {
    @Mock
    SocialMeliService socialMeliServiceMock;

    @InjectMocks
    UsersController usersController;

    @Test
    public void findsIdOfUserToFollow() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {

        User azul = TestUtilsGenerator.getAzul();
        User fede = TestUtilsGenerator.getFede();

        when(socialMeliServiceMock.getUserById(2)).thenReturn(azul);
        when(socialMeliServiceMock.getUserById(3)).thenReturn(fede);

        usersController.followUser(2, 3);

        verify(socialMeliServiceMock, atLeastOnce()).follow(2, 3);
        reset(socialMeliServiceMock);

    }

    @Test
    public void findsIdOfUserToUnFollow() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {

        User azul = TestUtilsGenerator.getAzul();
        User fede = TestUtilsGenerator.getFede();

        when(socialMeliServiceMock.getUserById(2)).thenReturn(azul);
        when(socialMeliServiceMock.getUserById(3)).thenReturn(fede);

        usersController.unfollowUser(2, 3);

        verify(socialMeliServiceMock, atLeastOnce()).unfollow(2, 3);
        reset(socialMeliServiceMock);

    }

    @Test
    public void getFollowersCount() throws UserNotFoundException {

        when(socialMeliServiceMock.countFollowers(3)).thenReturn(new CountFollowersResponseDTO());

        usersController.countFollowers(3);

        verify(socialMeliServiceMock, atLeastOnce()).countFollowers(3);
        reset(socialMeliServiceMock);

    }
}
