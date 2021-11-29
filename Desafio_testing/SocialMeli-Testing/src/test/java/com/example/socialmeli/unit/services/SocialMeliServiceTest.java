package com.example.socialmeli.unit.services;

import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class SocialMeliServiceTest {

    @Mock
    private PostRepository mockPostRepository;

    @Mock
    private UsuarioRepository mockUserRepository;

    @InjectMocks
    SocialMeliService service;

    @Test
    void foundUserById() throws UserNotFoundException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        User userFound = service.getUserById(1);

        //Assert
        Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
        Assertions.assertEquals(user, userFound);
    }
    @Test
    void notFoundUserById() {
        //Mock
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.empty());
        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.getUserById(2));
    }

    @Test
    @DisplayName("Encontramos el usuario a seguir")
    void findUserToFollow() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");

        //Act
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        service.follow(1,2);

        //Act && Assert
        Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(2);

    }
    @Test
    @DisplayName("No existe el usuario a seguir")
    void UserToFollowDoesNotExist() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.empty());
        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }

    @Test
    @DisplayName("Encontramos el usuario a dejar de seguir")
    void findUserToUnfollow() throws UserNotFoundException, UserAlreadyInUseException, UserSelfUseException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");

        //Act
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        service.follow(1,2);

        //Act && Assert
        Mockito.verify(mockUserRepository, Mockito.atLeastOnce()).findById(2);

    }

    @Test
    @DisplayName("No existe el usuario a dejar de seguir")
    void UserToUnfollowDoesNotExist() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.empty());

        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }

    @Test
    @DisplayName("Lanzamos un error, cuando el order esta en null, aunque no falle")
    void getFollowersWhithoutOrder() {
        Assertions.assertThrows(NullPointerException.class, () -> service.getFollowers(1,null));
    }

    @Test
    void getFollowersByOrderAscCorrectly() throws UserNotFoundException {
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Olivia Perez");

        Mockito.when(mockUserRepository.findById(2)).thenReturn(Optional.of(user2));

        FollowersResponseDTO followersListDto = service.getFollowers (2, "name_asc");
        System.out.println(followersListDto.getFollowers());
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        Assertions.assertTrue(Comparators.isInOrder(followersListDto.getFollowers(), comparator));
    }

    @Test
    @DisplayName("Lanzamos un error, cuando el order esta en null, aunque no falle")
    void getPostWhithoutOrder() {
        Assertions.assertThrows(NullPointerException.class, () -> service.getFollowedPostList(1, null));
    }

    @Test
    void getFollowed() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void getFollowedList() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void countFollowers() throws UserNotFoundException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        user.setFollowersId(Arrays.asList(2,3));
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Integer count = service.countFollowers(1).getFollowersCount();
        //Assert
        Assertions.assertEquals(user.getFollowersId().size(), count);
    }

    @Test
    void getPostById() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void pushPost() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void getFollowedPostList() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void getUserPostRequest() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void getPromoCount() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void getPromoPosts() {
        //Arrange
        //Act
        //Assert
    }
}