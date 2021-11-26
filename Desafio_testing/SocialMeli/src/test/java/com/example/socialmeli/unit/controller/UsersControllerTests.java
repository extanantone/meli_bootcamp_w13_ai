package com.example.socialmeli.unit.controller;

import com.example.socialmeli.controllers.UsersController;
import com.example.socialmeli.dto.response.FollowedResponseDTO;
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
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTests {
    @Mock
    SocialMeliService socialMeliService;

    @InjectMocks
    UsersController usersController;

    @Test
    public void findsIdOfUserToFollow() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {

        User manuel = new User();
        manuel.setUserId(3);
        manuel.setUserName("Manuel Vendedor");

        when(socialMeliService.getUserById(2)).thenReturn(new User());
        when(socialMeliService.getUserById(3)).thenReturn(manuel);

        usersController.followUser(2, 3);

        verify(socialMeliService, atLeastOnce()).follow(2, 3);

        reset(socialMeliService);

    }

    @Test
    public void findsIdOfUserToUnFollow() throws UserNotFoundException, UserSelfUseException, UserAlreadyInUseException {

        User manuel = new User();
        manuel.setUserId(3);
        manuel.setUserName("Manuel Vendedor");

        User juana = new User();
        juana.setUserId(2);
        juana.setUserName("Juana");
        juana.setFollowersId(List.of(3));

        when(socialMeliService.getUserById(2)).thenReturn(juana);
        when(socialMeliService.getUserById(3)).thenReturn(manuel);

        usersController.unfollowUser(2, 3);

        verify(socialMeliService, atLeastOnce()).unfollow(2, 3);

        reset(socialMeliService);

    }
}
