package com.example.socialmeli.unit.controller;

import com.example.socialmeli.controllers.UsersController;
import com.example.socialmeli.dto.response.CountFollowersResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    SocialMeliService socialMeliServiceMock;

    @InjectMocks
    UsersController usersController;

    @AfterEach
    public void resetMocks() {
        reset(socialMeliServiceMock);
    }
    @Test
    void getExistingUserToFollow() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User follower = new User();
        follower.setUserId(10);
        follower.setUserName("Leon Comprador10");
        follower.setFollowersId(new ArrayList<>());

        User userToFollow = new User();
        userToFollow.setUserId(11);
        userToFollow.setUserName("Juan Comprador11");
        userToFollow.setFollowersId(new ArrayList<>());

        //Mocks
        when(socialMeliServiceMock.getUserById(10)).thenReturn(follower);
        when(socialMeliServiceMock.getUserById(11)).thenReturn(userToFollow);

        //Act
        usersController.followUser(10,11);

        //Assert
        verify(socialMeliServiceMock, atLeastOnce()).follow(10, 11);
    }
    @Test
    void getExistingUserToUnFollow() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User follower = new User();
        follower.setUserId(10);
        follower.setUserName("Leon Comprador10");
        follower.setFollowersId(new ArrayList<>());

        User userToUnFollow = new User();
        userToUnFollow.setUserId(11);
        userToUnFollow.setUserName("Juan Comprador11");
        userToUnFollow.setFollowersId(new ArrayList<>());

        //Mocks
        when(socialMeliServiceMock.getUserById(10)).thenReturn(follower);
        when(socialMeliServiceMock.getUserById(11)).thenReturn(userToUnFollow);

        //Act
        usersController.unfollowUser(10,11);

        //Assert
        verify(socialMeliServiceMock, atLeastOnce()).unfollow(10, 11);
    }

    @Test
    public void getFollowersCount() throws UserNotFoundException {

        when(socialMeliServiceMock.countFollowers(4)).thenReturn(new CountFollowersResponseDTO());

        usersController.countFollowers(4);

        verify(socialMeliServiceMock, atLeastOnce()).countFollowers(4);

    }

}
