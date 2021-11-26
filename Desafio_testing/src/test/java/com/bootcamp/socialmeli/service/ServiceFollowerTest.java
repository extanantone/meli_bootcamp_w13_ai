package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static com.bootcamp.socialmeli.repository.UserRepository.inicializarUsers;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceFollowerTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ServiceFollower serviceFollower;

    @Test
    void userToFollowVerifyUserExistence() {

        inicializarUsers();

        int idUser = 1;
        int idUserToFollow = 2;

        Mockito.when(userRepository.findById(idUserToFollow)).thenThrow(RuntimeException.class);

        ResponseEntity expectedResponse = new ResponseEntity<>("Usuario inexistente",HttpStatus.BAD_REQUEST);

        //Act and Assert
        Assertions.assertEquals(expectedResponse,serviceFollower.userToFollow(idUser,idUserToFollow));
    }


    @Test
    void userToUnfollowVerifyUserExistence() {

        inicializarUsers();

        int idUser = 1;
        int idUserToFollow = 2;

        Mockito.when(userRepository.findById(idUserToFollow)).thenThrow(RuntimeException.class);

        ResponseEntity expectedResponse = new ResponseEntity<>("Usuario inexistente",HttpStatus.BAD_REQUEST);

        //Act and Assert
        Assertions.assertEquals(expectedResponse,serviceFollower.userToFollow(idUser,idUserToFollow));
    }



}