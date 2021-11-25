package com.socialMeli.SocialMeli.Controller;

import com.socialMeli.SocialMeli.controller.ApplicationController;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.service.PostService;
import com.socialMeli.SocialMeli.service.UserService;
import com.socialMeli.SocialMeli.userDto.UserFollowDTO;
import com.socialMeli.SocialMeli.userDto.UserFollowersCountDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ApplicationControllerTest {
    @Mock
    UserService userService;

    @Mock
    PostService postService;

    @InjectMocks
    ApplicationController applicationController;

    static UserFollowDTO userFollowDTO;
    static UserFollowersCountDTO userFollowersCountDTO;

    @BeforeAll
    private static void initialize(){
        userFollowDTO=new UserFollowDTO(new User(1,"usuario1"));
        userFollowersCountDTO=new UserFollowersCountDTO(1,"usuario1",2 );
    }

    //T-0001

    @Test
    void followExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userService.follow(user_id,user_to_follow_id)).thenReturn(userFollowDTO);
        applicationController.follow(user_id,user_to_follow_id);

        //assert
        Mockito.verify(userService, Mockito.atLeastOnce()).follow(user_id,user_to_follow_id);
    }

    @Test
    void followUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userService.follow(user_id,user_to_follow_id)).thenThrow(new NotFoundUserException());

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> applicationController.follow(user_id,user_to_follow_id));
        Mockito.verify(userService, Mockito.atLeastOnce()).follow(user_id,user_to_follow_id);

    }

    //T-0002

    @Test
    void unfollowExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_unfollow_id=2;

        //act
        Mockito.when(userService.unfollow(user_id,user_to_unfollow_id)).thenReturn(userFollowDTO);

        //assert
        Assertions.assertEquals(new ResponseEntity<>(Optional.of(userFollowDTO),HttpStatus.OK), applicationController.unfollow(user_id,user_to_unfollow_id));
        Mockito.verify(userService, Mockito.atLeastOnce()).unfollow(user_id,user_to_unfollow_id);
    }

    @Test
    void unfollowUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userService.unfollow(user_id,user_to_follow_id)).thenThrow(new NotFoundUserException());

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> applicationController.unfollow(user_id,user_to_follow_id));
        Mockito.verify(userService, Mockito.atLeastOnce()).unfollow(user_id,user_to_follow_id);
    }

    //T-0003




}
