package com.example.socialmeli.controller;

import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;
import com.example.socialmeli.exceptions.UserNoFound;
import com.example.socialmeli.services.ProductServices;
import com.example.socialmeli.services.UserServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class controllerTest {

    @Mock
    UserServices mockUserService;
    ProductServices mockProductsService;

    @InjectMocks
    ControllerSocialMeli controller;


    @Test
    void followUserOK(){
        Integer user1 = 1;
        Integer user2 = 2;
        DTOEmptyJsonResponse response = new DTOEmptyJsonResponse();
        when(mockUserService.followUser(1,2)).thenReturn(response);
        assertEquals(200, controller.followUser(user1, user2).getStatusCode().value());
    }

    @Test
    void followUserFail() throws UserNoFound{
        Integer user1 = 1;
        DTOEmptyJsonResponse response = new DTOEmptyJsonResponse();
        when(mockUserService.followUser(user1,6)).thenThrow(new UserNoFound());
        assertThrows(UserNoFound.class, () -> controller.followUser(user1, 6));
    }

    @Test
    void UnfollowUserOK(){
        Integer user1  = 1;
        Integer user2 = 2;
        DTOEmptyJsonResponse response = new DTOEmptyJsonResponse();
        when(mockUserService.unFollow(user1,user2)).thenReturn(response);
        assertEquals(200, controller.unFollowUser(user1, user2).getStatusCode().value());
    }

    @Test
    void UnfollowUserFail(){
        Integer user1  = 1;
        Integer user2 = 2;
        DTOEmptyJsonResponse response = new DTOEmptyJsonResponse();
        when(mockUserService.unFollow(user1,99)).thenThrow(new UserNoFound());
        assertThrows(UserNoFound.class, ()-> controller.unFollowUser(user1, 99));
    }



}
