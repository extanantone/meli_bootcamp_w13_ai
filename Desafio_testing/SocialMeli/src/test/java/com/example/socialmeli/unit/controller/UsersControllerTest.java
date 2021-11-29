package com.example.socialmeli.unit.controller;

import com.example.socialmeli.controllers.UsersController;
import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.FollowedResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

    @Mock
    private SocialMeliService socialMeliService;

    @InjectMocks
    private UsersController usersController;

    @Test
    public void testFollowUser() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;

        //Act
        usersController.followUser(userId, userIdToFollow);

        //Assert
        Mockito.verify(socialMeliService, atLeastOnce()).follow(userId, userIdToFollow);
    }

    @Test
    public void testUnFollowUser() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;

        //Act
        usersController.unfollowUser(userId, userIdToFollow);

        //Assert
        Mockito.verify(socialMeliService, atLeastOnce()).unfollow(userId, userIdToFollow);
    }

    @Test
    public void testGetFollowersParams() throws UserNotFoundException {
        //Arrange
        Integer userId = 1;
        String order = "name_asc";

        //Act
        usersController.getFollowers(userId, order);

        //Assert
        Mockito.verify(socialMeliService, atLeastOnce()).getFollowers(userId, order);
    }
    @Test
    public void testGetFollowedParams() throws UserNotFoundException {
        //Arrange
        Integer userId = 1;
        String order = "name_asc";

        //Act
        usersController.getFollowed(userId, order);

        //Assert
        Mockito.verify(socialMeliService, atLeastOnce()).getFollowed(userId, order);
    }
}

