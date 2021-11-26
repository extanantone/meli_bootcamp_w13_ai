package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.IllegalRequestParamException;
import com.bootcamp.socialmeli.exception.UserNotFoundException;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.repository.UserRepositoryImpl;
import com.bootcamp.socialmeli.util.OrderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private OrderUtils orderUtils;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void followFailsUserNotFoundTest(){
        User user = new User(1L, "Juan", null, null);
        Mockito.when(userRepository.getUser(1L)).thenReturn(user);
        Mockito.when(userRepository.getUser(2L)).thenReturn(null);
        Exception exception = Assertions.assertThrows(UserNotFoundException.class, () -> userService.follow(1L,2L));

        String expectedMessage = "Usuario no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void followSuccessTest(){
        User user1 = new User(1L, "Juan", null, null);
        User user2 = new User(2L, "Camilo", null, null);
        Mockito.when(userRepository.getUser(1L)).thenReturn(user1);
        Mockito.when(userRepository.getUser(2L)).thenReturn(user2);
        Mockito.when(userRepository.follow(Mockito.any(User.class), Mockito.any(User.class))).thenReturn(true);
        Assertions.assertTrue(userService.follow(1L,2L));
    }

    @Test
    void unfollowFailsUserNotFoundTest(){
        User user = new User(1L, "Juan", null, null);
        Mockito.when(userRepository.getUser(1L)).thenReturn(user);
        Mockito.when(userRepository.getUser(2L)).thenReturn(null);
        Exception exception = Assertions.assertThrows(UserNotFoundException.class, () -> userService.unfollow(1L,2L));

        String expectedMessage = "Usuario no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void unfollowSuccessTest(){
        User user1 = new User(1L, "Juan", null, null);
        User user2 = new User(2L, "Camilo", null, null);
        Mockito.when(userRepository.getUser(1L)).thenReturn(user1);
        Mockito.when(userRepository.getUser(2L)).thenReturn(user2);
        Mockito.when(userRepository.unfollow(Mockito.any(User.class), Mockito.any(User.class))).thenReturn(true);
        Assertions.assertTrue(userService.unfollow(1L,2L));
    }

    @Test
    void orderingParamIllegalValueTest(){
        User user = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        FollowerListResponseDTO followersList = new FollowerListResponseDTO(1L, "Juan", new ArrayList<>());
        Mockito.when(userRepository.getUser(1L)).thenReturn(user);
        Mockito.when(orderUtils.order(Mockito.any(FollowerListResponseDTO.class), Mockito.anyString())).thenThrow(IllegalRequestParamException.class);
        Mockito.when(userMapper.userToFollowerList(Mockito.any(User.class))).thenReturn(followersList);
        Exception exception = Assertions.assertThrows(IllegalRequestParamException.class, () -> userService.followersList(user.getUserId(), "sadasd"));
    }

    @Test
    void orderingParamIllegalValueNullTest(){
        User user = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        FollowerListResponseDTO followersList = new FollowerListResponseDTO(1L, "Juan", new ArrayList<>());
        Mockito.when(userRepository.getUser(1L)).thenReturn(user);
        Exception exception = Assertions.assertThrows(IllegalRequestParamException.class, () -> userService.followersList(user.getUserId(), null));
    }

    @Test
    void orderingParamFollowerListTest(){
        User user = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        FollowerListResponseDTO followersList = new FollowerListResponseDTO(1L, "Juan", new ArrayList<>());
        Mockito.when(userRepository.getUser(1L)).thenReturn(user);
        Mockito.when(orderUtils.order(Mockito.any(FollowerListResponseDTO.class), Mockito.anyString())).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(userMapper.userToFollowerList(Mockito.any(User.class))).thenReturn(followersList);
        FollowerListResponseDTO actual = userService.followersList(user.getUserId(), "name_desc");
        verify(orderUtils, times(1)).order(Mockito.any(FollowerListResponseDTO.class), Mockito.anyString());
        verify(userMapper, times(1)).userToFollowerList(Mockito.any(User.class));
        Assertions.assertEquals(followersList, actual);
    }

    @Test
    void orderingParamFollowedListTest(){
        User user = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        FollowedListResponseDTO followedList = new FollowedListResponseDTO(1L, "Juan", new ArrayList<>());
        Mockito.when(userRepository.getUser(1L)).thenReturn(user);
        Mockito.when(orderUtils.order(Mockito.any(FollowedListResponseDTO.class), Mockito.anyString())).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(userMapper.userToFollowedList(Mockito.any(User.class))).thenReturn(followedList);
        FollowedListResponseDTO actual = userService.followedList(user.getUserId(), "name_desc");
        verify(orderUtils, times(1)).order(Mockito.any(FollowedListResponseDTO.class), Mockito.anyString());
        verify(userMapper, times(1)).userToFollowedList(Mockito.any(User.class));
        Assertions.assertEquals(followedList, actual);
    }

    @Test
    void followerCountTest(){
        User user1 = new User(1L, "Juan", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2L, "Camilo", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3L, "Lozano", new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4L, "Mejia", new ArrayList<>(List.of(user1,user2,user3)), new ArrayList<>());
        Integer expected = 3;
        Mockito.when(userRepository.getUser(Mockito.anyLong())).thenReturn(user4);
        FollowerCountResponseDTO actual = userService.followersCount(4L);
        Assertions.assertEquals(expected, actual.getFollowersCount());
    }


}
