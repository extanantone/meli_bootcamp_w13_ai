package com.example.socialmeli.unit.services;

import com.example.socialmeli.dto.ErrorDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SocialMeliServiceTest {

    @Mock
    private PostRepository mockPostRepository;

    @Mock
    private UsuarioRepository mockUsuarioRepository;

    @InjectMocks
    SocialMeliService service;

    @Test
    void foundUserById() throws UserNotFoundException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");

        //Act
        Mockito.when(mockUsuarioRepository.findById(1)).thenReturn(Optional.of(user));
        User userFound = service.getUserById(1);

        //Assert
        Mockito.verify(mockUsuarioRepository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
        Assertions.assertEquals(user, userFound);
    }
    @Test
    void notFoundUserById() {
        //Mock
        Mockito.when(mockUsuarioRepository.findById(2)).thenReturn(Optional.empty());
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
        Mockito.when(mockUsuarioRepository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(mockUsuarioRepository.findById(1)).thenReturn(Optional.of(user));
        service.follow(1,2);

        //Act && Assert
        Mockito.verify(mockUsuarioRepository, Mockito.atLeastOnce()).findById(2);

    }
    @Test
    @DisplayName("No existe el usuario a seguir")
    void UserToFollowDoesNotExist() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        //Act
        Mockito.when(mockUsuarioRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(mockUsuarioRepository.findById(2)).thenReturn(Optional.empty());
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
        Mockito.when(mockUsuarioRepository.findById(2)).thenReturn(Optional.of(user2));
        Mockito.when(mockUsuarioRepository.findById(1)).thenReturn(Optional.of(user));
        service.follow(1,2);

        //Act && Assert
        Mockito.verify(mockUsuarioRepository, Mockito.atLeastOnce()).findById(2);

    }

    @Test
    @DisplayName("No existe el usuario a dejar de seguir")
    void UserToUnfollowDoesNotExist() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Sofia Menichelli");
        //Act
        Mockito.when(mockUsuarioRepository.findById(1)).thenReturn(Optional.of(user));
        Mockito.when(mockUsuarioRepository.findById(2)).thenReturn(Optional.empty());
        //Act && Assert
        Assertions.assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }

    @Test
    void getFollowers() {
        //Arrange
        //Act
        //Assert
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
    void countFollowers() {
        //Arrange
        //Act
        //Assert
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