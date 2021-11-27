package com.example.SocialMeli.services;

import com.example.SocialMeli.entities.User;
import com.example.SocialMeli.exception.UserNotFoundException;
import com.example.SocialMeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl service;

    User u = new User(1L, "ftalgiero");
    User u2 = new User(2L, "juangomez");


    //T-0001
    /*
    Verificar que el usuario a seguir exista.
     */
    @Test
    void testUserIdToFollowExist() {
        // Mocks
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(2)).thenReturn(u2);

        // act y assert
        Assertions.assertDoesNotThrow(() -> service.saveFollow(2,1));

        verify(userRepository, atLeastOnce()).getById(1);
    }

    //T-0001
    /*
    El usuario no existe y se lanza la exception UserNotFoundException.
     */
    @Test
    void testUserIdToFollowNotExist() {
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(12)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> service.saveFollow(1,12));
        verify(userRepository, atLeastOnce()).getById(1);
    }

    @Test
    void testUserIdToUnfollowExist() {
        //Mocks
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(2)).thenReturn(u2);
        Assertions.assertTrue(service.unfollow(1,2));
    }

    @Test
    void testUserIdToUnfollowDoesntExist() {
        when(userRepository.getById(1)).thenReturn(u);
        when(userRepository.getById(12)).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> service.unfollow(1,12));
    }

}