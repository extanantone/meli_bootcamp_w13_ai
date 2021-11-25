package com.socialMeli.SocialMeli.Service;

import com.socialMeli.SocialMeli.exception.userExceptions.FollowItselfException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.repository.UserRepository;
import com.socialMeli.SocialMeli.service.UserServiceImp;
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

import java.util.HashMap;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImp userService;

    static  User user;
    static UserFollowDTO userFollowDTO;
    static HashMap<Integer, User> list_users;

    @BeforeAll
    private static void initialize(){
        User user1= new User(1,"usuario1");
        User user2= new User(2,"usuario2");
        userFollowDTO=new UserFollowDTO(user1);
        list_users = new HashMap<>();
        list_users.put(1,user1);
        list_users.put(2,user2);
    }

    //T-0001

    @Test
    void followExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=2;

        //act
        Mockito.when(userRepository.follow(user_id,user_to_follow_id)).thenReturn(userFollowDTO);
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertEquals(userFollowDTO,userService.follow(user_id,user_to_follow_id));
        Mockito.verify(userRepository, Mockito.atLeastOnce()).follow(user_id,user_to_follow_id);
    }

    @Test
    void followUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_unexisting_id=3;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> userService.follow(user_id,user_unexisting_id));
    }

    @Test
    void followSelfUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_follow_id=1;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertThrows(FollowItselfException.class,() -> userService.follow(user_id,user_to_follow_id));
    }

    //T-0002

    @Test
    void unfollowExistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_unfollow_id=2;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);
        Mockito.when(userRepository.unfollow(user_id,user_to_unfollow_id)).thenReturn(userFollowDTO);

        //assert
        Assertions.assertEquals(userFollowDTO.getId(), userService.unfollow(user_id,user_to_unfollow_id).getId());
        Mockito.verify(userRepository, Mockito.atLeastOnce()).unfollow(user_id,user_to_unfollow_id);
    }

    @Test
    void unfollowUnexistingUser(){
        //arrange
        Integer user_id=1;
        Integer user_to_unfollow_id=5;

        //act
        Mockito.when(userRepository.getList_users()).thenReturn(list_users);

        //assert
        Assertions.assertThrows(NotFoundUserException.class,() -> userService.unfollow(user_id,user_to_unfollow_id));
    }





}
