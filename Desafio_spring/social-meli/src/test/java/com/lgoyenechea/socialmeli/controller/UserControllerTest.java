package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService mockUserService;

    @InjectMocks
    UserController userController;

    @Test
    void givenCorrectUser_whenNewUser_thenCreated() {
        UserDTO dto = new UserDTO();
        when(mockUserService.save(any())).thenReturn(dto);
        ResponseEntity<UserDTO> response = userController.newUser(new UserCreationDTO());
        verify(mockUserService, times(1)).save(any());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void givenCorrectUsersIds_whenFollow_thenOk() {
        UserFollowDTO dto = new UserFollowDTO();
        when(mockUserService.follow(any(), any())).thenReturn(dto);
        ResponseEntity<UserFollowDTO> response = userController.follow(1L, 2L);
        verify(mockUserService, times(1)).follow(any(), any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectUserId_whenFollowersCount_thenOk() {
        UserFollowersCountDTO dto = new UserFollowersCountDTO();
        when(mockUserService.followersCount(any())).thenReturn(dto);
        ResponseEntity<UserFollowersCountDTO> response = userController.followersCount(1L);
        verify(mockUserService, times(1)).followersCount(any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectUserId_whenFollowersList_thenOk() {
        UserFollowersListDTO dto = new UserFollowersListDTO();
        when(mockUserService.followersList(any(), any())).thenReturn(dto);
        ResponseEntity<UserFollowersListDTO> response = userController.followersList(1L, "name_asc");
        verify(mockUserService, times(1)).followersList(any(), any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectUserId_whenFollowedList_thenOk() {
        UserFollowedListDTO dto = new UserFollowedListDTO();
        when(mockUserService.followedList(any(), any())).thenReturn(dto);
        ResponseEntity<UserFollowedListDTO> response = userController.followedList(1L, "name_asc");
        verify(mockUserService, times(1)).followedList(any(), any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void givenCorrectUsersId_whenUnfollow_thenOk() {
        UserUnfollowDTO dto = new UserUnfollowDTO();
        when(mockUserService.unfollow(any(), any())).thenReturn(dto);
        ResponseEntity<UserUnfollowDTO> response = userController.unfollow(1L, 2L);
        verify(mockUserService, times(1)).unfollow(any(), any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}