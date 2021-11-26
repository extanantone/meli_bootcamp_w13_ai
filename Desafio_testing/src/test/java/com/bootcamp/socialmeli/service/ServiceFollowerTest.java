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
import static com.bootcamp.socialmeli.repository.UserRepository.listUsers;
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


    @Test
    void getCountFollowersTest(){

        inicializarUsers();

        int countFollowers = 3;
        int userId = 1;

        User user1 = listUsers.get(0);
        User user2 = listUsers.get(1);
        User user3 = listUsers.get(2);
        User user4 = listUsers.get(3);

        user2.getListFolows().put(1,user1);
        user3.getListFolows().put(1,user1);
        user4.getListFolows().put(1,user1);

        Mockito.when(userRepository.getCountFollowersOfuser(userId)).thenReturn(3);

        int count = userRepository.getCountFollowersOfuser(userId);

        Assertions.assertEquals(countFollowers,count);


    }

}