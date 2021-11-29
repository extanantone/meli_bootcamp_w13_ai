package com.bootcamp.socialmeli.unit.service;

import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.dto.UserFollowedDTO;
import com.bootcamp.socialmeli.dto.UserFollowersDTO;
import com.bootcamp.socialmeli.exception.NotFoundOrderParamException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.service.UserService;
import com.google.common.collect.Comparators;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    static User userTest;
    static User userTest2;
    static User userFollowedTest;
    static User userFollowedTest2;

    @BeforeAll
    public static void initializingVariablesForTesting(){
        userTest = new User(1, "Nico");
        userTest2 = new User(2,"Juan");
        userFollowedTest = new User(3, "Pedro");
        userFollowedTest2 = new User(4,"Carlos");
    }

    @BeforeEach
    @DisplayName("Reseteo los usuarios (elimino seguidores y seguidos, y post realizados")
    void resetVariablesForTesting(){
        //Reseteo los usuarios seguidos del usuario comprador
        userTest.removeAllFollowed();
        userTest2.removeAllFollowed();
        //Reseteo seguidores del usuario vendedor
        userFollowedTest.removeAllFollower();
    }


    @Test
    @DisplayName("En caso de usuarios válidos, se debe poder hacer follow sin desencadenar ninguna excepcion")
    void shouldNotThrowExceptionWhenFollowValidUser() throws NotPossibleOperationException {
        //Arrange
        int userId = 1;
        int userFollowedId = 3;
        Mockito.when(userRepository.getUser(userId)).thenReturn(userTest);
        Mockito.when(userRepository.getUser(userFollowedId)).thenReturn(userFollowedTest);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> userService.followUser(userId, userFollowedId));
    }

    @Test
    @DisplayName("En caso de usuarios inválidos (uno o ambos), se debe desencadenar una excepcion")
    void shouldThrowExceptionWhenFollowInvalidUser() throws NotPossibleOperationException {
        //Arrange
        int userId = 1;
        int invalidUserFollowedId = Mockito.anyInt();

        Mockito.when(userRepository.getUser(userId)).thenReturn(userTest);
        Mockito.when(userRepository.getUser(invalidUserFollowedId)).thenThrow(NotPossibleOperationException.class);

        //Act & Assert
        Assertions.assertThrows(NotPossibleOperationException.class,() -> userService.followUser(userId, invalidUserFollowedId));
    }

    @Test
    @DisplayName("En caso de usuarios válidos, se debe poder hacer unfollow sin desencadenar ninguna excepcion")
    void shouldNotThrowExceptionWhenUnfollowValidUser() throws NotPossibleOperationException {
        //Arrange
        int userId = 1;
        int userFollowedId = 3;
        userTest.addFollowed(userFollowedId);
        userFollowedTest.addFollower(userId);

        Mockito.when(userRepository.getUser(userId)).thenReturn(userTest);
        Mockito.when(userRepository.getUser(userFollowedId)).thenReturn(userFollowedTest);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> userService.unfollowUser(userId, userFollowedId));
    }


    @Test
    @DisplayName("En caso de usuarios inválidos (uno o ambos), se debe desencadenar una excepcion")
    void shouldThrowExceptionWhenUnfollowInvalidUser() throws NotPossibleOperationException {
        //Arrange
        int userId = 1;
        int invalidUserFollowedId = Mockito.anyInt();

        Mockito.when(userRepository.getUser(userId)).thenReturn(userTest);
        Mockito.when(userRepository.getUser(invalidUserFollowedId)).thenThrow(NotPossibleOperationException.class);

        //Act & Assert
        Assertions.assertThrows(NotPossibleOperationException.class,() -> userService.unfollowUser(userId, invalidUserFollowedId));
    }

    @Test
    void shouldReturnFollowersInAscOrder() throws NotPossibleOperationException {
        //Arrange
        UserFollowersDTO expected = new UserFollowersDTO(userFollowedTest.getId(),userFollowedTest.getName());
        expected.setFollowers(Arrays.asList(
                new UserDTO(userTest.getId(), userTest.getName()),
                new UserDTO(userTest2.getId(), userTest2.getName())
        ));
        String order = "name_asc";

        List<User> followers = Arrays.asList(userTest, userTest2);

        UserFollowersDTO current;

        Mockito.when(userRepository.getUser(userFollowedTest.getId())).thenReturn(userFollowedTest);
        Mockito.when(userRepository.getUsersFollowers(userFollowedTest.getId())).thenReturn(followers);
        //Act
        current = userService.getUsersFollowers(userFollowedTest.getId(), order);

        //Assert
        Assertions.assertEquals(expected, current);

        Comparator<UserDTO> comparator = Comparator.comparing(userDTO -> userDTO.getUserName());

        Assertions.assertTrue(Comparators.isInOrder(current.getFollowers(), comparator));

    }



    @Test
    void shouldReturnFollowersInDescOrder() throws NotPossibleOperationException {
        //Arrange
        UserFollowersDTO expected = new UserFollowersDTO(userFollowedTest.getId(),userFollowedTest.getName());

        expected.setFollowers(Arrays.asList(
                new UserDTO(userTest.getId(), userTest.getName()),
                new UserDTO(userTest2.getId(), userTest2.getName())
                ));

        String order = "name_desc";

        List<User> followers = Arrays.asList(userTest, userTest2);

        UserFollowersDTO current;

        Mockito.when(userRepository.getUser(userFollowedTest.getId())).thenReturn(userFollowedTest);
        Mockito.when(userRepository.getUsersFollowers(userFollowedTest.getId())).thenReturn(followers);
        //Act
        current = userService.getUsersFollowers(userFollowedTest.getId(), order);

        //Assert
        Assertions.assertEquals(expected, current);

        Comparator<UserDTO> comparator = Comparator.comparing(userDTO -> userDTO.getUserName());

        Assertions.assertTrue(Comparators.isInOrder(Lists.reverse(current.getFollowers()), comparator));

    }

    @Test
    void shouldReturnFollowedInAscOrder() throws NotPossibleOperationException {
        //Arrange
        UserFollowedDTO expected = new UserFollowedDTO(userTest.getId(),userTest.getName());
        expected.setFollowed(Arrays.asList(
                new UserDTO(userFollowedTest.getId(), userFollowedTest.getName()),
                new UserDTO(userFollowedTest2.getId(), userFollowedTest2.getName())
        ));
        String order = "name_asc";

        List<User> followed = Arrays.asList(userFollowedTest, userFollowedTest2);

        UserFollowedDTO current;

        Mockito.when(userRepository.getUser(userTest.getId())).thenReturn(userTest);
        Mockito.when(userRepository.getUsersFollowed(userTest)).thenReturn(followed);
        //Act
        current = userService.getUsersFollowed(userTest.getId(), order);

        //Assert
        Assertions.assertEquals(expected, current);

        Comparator<UserDTO> comparator = Comparator.comparing(userDTO -> userDTO.getUserName());

        Assertions.assertTrue(Comparators.isInOrder(current.getFollowed(), comparator));

    }

    @Test
    void shouldReturnFollowedInDescOrder() throws NotPossibleOperationException {
        //Arrange
        UserFollowedDTO expected = new UserFollowedDTO(userTest.getId(),userTest.getName());
        expected.setFollowed(Arrays.asList(
                new UserDTO(userFollowedTest.getId(), userFollowedTest.getName()),
                new UserDTO(userFollowedTest2.getId(), userFollowedTest2.getName())
        ));
        String order = "name_desc";

        List<User> followed = Arrays.asList(userFollowedTest, userFollowedTest2);

        UserFollowedDTO current;

        Mockito.when(userRepository.getUser(userTest.getId())).thenReturn(userTest);
        Mockito.when(userRepository.getUsersFollowed(userTest)).thenReturn(followed);
        //Act
        current = userService.getUsersFollowed(userTest.getId(), order);

        //Assert
        Assertions.assertEquals(expected, current);

        Comparator<UserDTO> comparator = Comparator.comparing(userDTO -> userDTO.getUserName());

        Assertions.assertTrue(Comparators.isInOrder(Lists.reverse(current.getFollowed()), comparator));

    }

    @Test
    void shouldThrowExceptionWhenOrderParamNotExist() throws NotPossibleOperationException {
        //Arrange
        UserFollowedDTO expected = new UserFollowedDTO(userTest.getId(),userTest.getName());
        expected.setFollowed(Arrays.asList(
                new UserDTO(userFollowedTest.getId(), userFollowedTest.getName()),
                new UserDTO(userFollowedTest2.getId(), userFollowedTest2.getName())
        ));
        String order = "invalid order param";

        List<User> followed = Arrays.asList(userFollowedTest, userFollowedTest2);

        Mockito.when(userRepository.getUser(userTest.getId())).thenReturn(userTest);
        Mockito.when(userRepository.getUsersFollowed(userTest)).thenReturn(followed);

        //Act & Assert
        Assertions.assertThrows(NotFoundOrderParamException.class,
                () -> userService.getUsersFollowed(userTest.getId(), order));

    }

    

}
