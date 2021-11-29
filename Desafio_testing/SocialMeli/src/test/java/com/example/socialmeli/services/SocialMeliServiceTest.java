package com.example.socialmeli.services;

import com.example.socialmeli.dto.UserDTO;
import com.example.socialmeli.dto.response.FollowersResponseDTO;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        user.setUserName("Luis Lopez");

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
        user.setUserName("Luis Lopez");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Lionel Messi");

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
        user.setUserName("Luis Lopez");
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
        user.setUserName("Luis Lopez");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Lionel Messi");

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
        user.setUserName("Luis Lopez");
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
    void countFollowers() throws UserNotFoundException {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Luis Lopez");
        user.setFollowersId(Arrays.asList(2,3));
        //Act
        Mockito.when(mockUserRepository.findById(1)).thenReturn(Optional.of(user));
        Integer count = service.countFollowers(1).getFollowersCount();
        //Assert
        Assertions.assertEquals(user.getFollowersId().size(), count);
    }

}
