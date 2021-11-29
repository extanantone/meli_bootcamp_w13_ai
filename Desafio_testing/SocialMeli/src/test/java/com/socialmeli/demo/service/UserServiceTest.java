package com.socialmeli.demo.service;

import com.socialmeli.demo.dto.UserDTO;
import com.socialmeli.demo.dto.UserFollowedDTO;
import com.socialmeli.demo.dto.UserFollowersDTO;
import com.socialmeli.demo.dto.UserWithFollowersCountDTO;
import com.socialmeli.demo.exceptions.BadRequestException;
import com.socialmeli.demo.exceptions.UserNotFoundException;
import com.socialmeli.demo.mapper.UserMapper;
import com.socialmeli.demo.model.User;
import com.socialmeli.demo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Spy
    UserMapper userMapper;

    @InjectMocks
    UserService userService;

    @AfterEach
    public void resetMocks() {
        reset(userRepository);
        reset(userMapper);
    }


    //T-0001(Se cumple)
    @Test
    public void checkUserExistsInFollowUserService() {

        //Arrange
        User follower = new User(1, "david_castillo", "david", "castillo" );
        User followed = new User(2, "lorena_castillo", "lorena", "castillo" );

        UserFollowedDTO expectedResult = new UserFollowedDTO();
        expectedResult.setUserId(follower.getUserId());
        expectedResult.setUserName(follower.getUserName());

        UserDTO followedDTO = new UserDTO(followed.getUserId(), followed.getUserName(), followed.getName(), followed.getLastName());

        expectedResult.setFollowed(List.of(followedDTO));

        Mockito.when(userRepository.findUserById(follower.getUserId())).thenReturn(follower);
        Mockito.when(userRepository.findUserById(followed.getUserId())).thenReturn(followed);

        //Act
        UserFollowedDTO currentResult = userService.followUser(follower.getUserId(), followed.getUserId());

        //Assert
        assertEquals(expectedResult, currentResult);

    }

    //T-0001(No se cumple)
    @Test
    public void checkUserDontExistsInFollowUserService() {

        //Assert
        User follower = new User(8, "test", "test", "test" );
        User followed = new User(9, "test", "test", "test" );

        Mockito.when(userRepository.findUserById(follower.getUserId())).thenReturn(null);
        Mockito.when(userRepository.findUserById(followed.getUserId())).thenReturn(null);

        //Act & Assert
        assertThrows(UserNotFoundException.class, () ->
                    userService.followUser(follower.getUserId(), followed.getUserId())
                );
    }

    //T-0002(Se cumple)
    @Test
    public void checkUserExistsInUnfollowUserService() {

        //Arrange
        User followerExpected = new User(1, "david_castillo", "david", "castillo" );
        User followedExpected = new User(2, "lorena_castillo", "lorena", "castillo" );

        Mockito.when(userRepository.findUserById(followerExpected.getUserId())).thenReturn(followerExpected);
        Mockito.when(userRepository.findUserById(followedExpected.getUserId())).thenReturn(followedExpected);

        //Act
        userService.followUser(followerExpected.getUserId(), followedExpected.getUserId());
        userService.unfollowUser(followerExpected.getUserId(), followedExpected.getUserId());

        User followerCurrent = userRepository.findUserById(followerExpected.getUserId());
        User followedCurrent = userRepository.findUserById(followedExpected.getUserId());

        //Assert
        assertAll(
                () -> assertEquals(followerExpected, followerCurrent),
                () -> assertEquals(followedExpected, followedCurrent)
        );
    }

    //T-0002(No se cumple)
    @Test
    public void checkUserDontExistsInUnfollowUserService() {

        //Arrange
        User follower = new User(8, "test", "test", "test" );
        User followed = new User(9, "test", "test", "test" );

        Mockito.when(userRepository.findUserById(follower.getUserId())).thenReturn(null);
        Mockito.when(userRepository.findUserById(followed.getUserId())).thenReturn(null);

        //Act & Assert
        assertThrows(UserNotFoundException.class, () ->
                userService.unfollowUser(follower.getUserId(), followed.getUserId())
        );
    }

    //T-0003(Se cumple(ascendete))
    @Test
    public void checkAlphabeticAscendingOrderExistsInGetUserFollowerList() {

        //Arrange
        User user = new User(2, "lorena_castillo", "lorena", "castillo" );
        String order = "name_asc";

        UserFollowersDTO expectedResponse = new UserFollowersDTO();
        expectedResponse.setUserId(user.getUserId());
        expectedResponse.setUserName(user.getUserName());
        expectedResponse.setFollowers(new ArrayList<UserDTO>());

        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);

        UserFollowersDTO currentResponse = userService.getUserFollowersList(user.getUserId(), order);

        //Assert
        assertEquals(expectedResponse, currentResponse);
    }

    //T-0003(Se cumple(descendente))

    @Test
    public void checkAlphabeticDescendingOrderExistsInGetUserFollowerList() {

        //Arrange
        User user = new User(2, "lorena_castillo", "lorena", "castillo" );
        String order = "name_desc";

        UserFollowersDTO expectedResponse = new UserFollowersDTO();
        expectedResponse.setUserId(user.getUserId());
        expectedResponse.setUserName(user.getUserName());
        expectedResponse.setFollowers(new ArrayList<UserDTO>());

        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);

        UserFollowersDTO currentResponse = userService.getUserFollowersList(user.getUserId(), order);

        //Assert
        assertEquals(expectedResponse, currentResponse);
    }

    //T-0003(No se cumple, en este caso el test va a fallar debido a que no tengo una excepcion para este caso)
    @Test
    public void checkAlphabeticOrderDoesntExistsInGetUserFollowerList() {

        //Arrange
        User user = new User(2, "lorena_castillo", "lorena", "castillo" );
        String order = "name";

        UserFollowersDTO expectedResponse = new UserFollowersDTO();
        expectedResponse.setUserId(user.getUserId());
        expectedResponse.setUserName(user.getUserName());
        expectedResponse.setFollowers(new ArrayList<UserDTO>());

        Mockito.when(userRepository.findUserById(user.getUserId())).thenReturn(user);

        UserFollowersDTO currentResponse = userService.getUserFollowersList(user.getUserId(), order);

        assertThrows(BadRequestException.class , () ->
                    userService.getUserFollowersList(user.getUserId(), order)
                );
    }

    //T-0004(Se cumple(orden ascendente))
    @Test
    public void checkAlphabeticAscendingOrderIsCorrectInGetUserFollowerList() {

        //Arrange
        User userDavid = new User(1, "david_castillo", "david", "castillo" );
        User userLorena = new User(2, "lorena_castillo", "lorena", "castillo" );
        User userLuna = new User(3, "luna_pachon", "luna", "pachon" );

        List<String> expectedResult = List.of("david_castillo", "luna_pachon");

        Mockito.when(userRepository.findUserById(userDavid.getUserId())).thenReturn(userDavid);
        Mockito.when(userRepository.findUserById(userLorena.getUserId())).thenReturn(userLorena);
        Mockito.when(userRepository.findUserById(userLuna.getUserId())).thenReturn(userLuna);

        //Act
        userService.followUser(1, 2);
        userService.followUser(3,2);

        List<String> currentResult = userService.getUserFollowersList(2, "name_asc")
                .getFollowers().stream().map(UserDTO::getUserName).collect(Collectors.toList());

        //Assert
        assertEquals(expectedResult, currentResult);
    }

    //T-0004(Se cumple(orden descendente))
    @Test
    public void checkAlphabeticDescendingOrderIsCorrectInGetUserFollowerList() {

        //Arrange
        User userDavid = new User(1, "david_castillo", "david", "castillo" );
        User userLorena = new User(2, "lorena_castillo", "lorena", "castillo" );
        User userLuna = new User(3, "luna_pachon", "luna", "pachon" );

        List<String> expectedResult = List.of("luna_pachon", "david_castillo");

        Mockito.when(userRepository.findUserById(userDavid.getUserId())).thenReturn(userDavid);
        Mockito.when(userRepository.findUserById(userLorena.getUserId())).thenReturn(userLorena);
        Mockito.when(userRepository.findUserById(userLuna.getUserId())).thenReturn(userLuna);

        //Act
        userService.followUser(1, 2);
        userService.followUser(3,2);

        List<String> currentResult = userService.getUserFollowersList(2, "name_desc")
                .getFollowers().stream().map(UserDTO::getUserName).collect(Collectors.toList());

        //Assert
        assertEquals(expectedResult, currentResult);
    }

    //T-0007
    @Test
    public void checkFollowersCountIsCorrectInGetUserFollowersCountService() {

        //Arrange
        User userDavid = new User(1, "david_castillo", "david", "castillo" );
        Integer expectedResult = 1;

        Mockito.when(userRepository.findUserById(Mockito.anyInt())).thenReturn(userDavid);

        //Act
        userService.followUser(1, 2);
        UserWithFollowersCountDTO currentResult = userService.getUserFollowersCount(2);

        //Assert
        Assertions.assertEquals(expectedResult, currentResult.getFollowersCount());
    }


}
