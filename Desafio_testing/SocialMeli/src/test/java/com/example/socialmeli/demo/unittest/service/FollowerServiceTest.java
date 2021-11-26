package com.example.socialmeli.demo.unittest.service;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestUserList;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowedList;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserFollowerCount;
import com.example.socialmeli.demo.exception.UserNotFoundException;
import com.example.socialmeli.demo.exception.VendorNotFoundException;
import com.example.socialmeli.demo.mapper.UsuarioMapper;
import com.example.socialmeli.demo.model.Followers;
import com.example.socialmeli.demo.model.Usuarios;
import com.example.socialmeli.demo.repository.IFollowerRepository;
import com.example.socialmeli.demo.service.FollowerService;
import com.example.socialmeli.demo.service.IUserService;
import com.example.socialmeli.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FollowerServiceTest {

    @Mock
    IFollowerRepository followerRepository;

    @Mock
    IUserService usuarioService;

    @InjectMocks
    FollowerService followerService;


    //T 0001:
    @Test
    void testFollowToDeterminatedUserWithAnExistentUserId(){

        //Arrange
        int userId = 1;
        int userToFollowId = 3;
        DTOUsuario userFollower = new DTOUsuario();
        userFollower.setUserId(userId);
        DTOUsuario userToFollow = new DTOUsuario();
        userToFollow.setUserId(userToFollowId);
        DTOFollowUser followUserRequest = new DTOFollowUser();
        followUserRequest.setUserId(userId);
        followUserRequest.setUserIdToFollow(userToFollowId);
        ResponseEntity expectedResponse = new ResponseEntity<>(HttpStatus.OK);

        //Mock
        Mockito.when(usuarioService.getUserByUserId(userToFollowId)).thenReturn(userToFollow);
        Mockito.when(usuarioService.getUserByUserId(userId)).thenReturn(userFollower);

        //Act
        ResponseEntity response = followerService.followUser(followUserRequest);

        //Assert
        verify(usuarioService, atLeastOnce()).getUserByUserId(userToFollowId);
        verify(usuarioService, atLeastOnce()).getUserByUserId(userId);
        Assertions.assertEquals(expectedResponse, response);


    }

    @Test
    void testFollowToDeterminatedUserWithAnUnexistentUserIdCausingVendorNotFoundException(){

        //Arrange
        int userId = 1;
        int userToFollowId = 10; //Este userId no existe
        DTOUsuario followerUser = new DTOUsuario();
        followerUser.setUserId(userId);
        DTOUsuario userToFollow = new DTOUsuario();
        userToFollow.setUserId(userToFollowId);
        DTOFollowUser followUserRequest = new DTOFollowUser();
        followUserRequest.setUserId(userId);
        followUserRequest.setUserIdToFollow(userToFollowId);
        VendorNotFoundException expectedResponse = new VendorNotFoundException();

        //Mock
        Mockito.when(usuarioService.getUserByUserId(userToFollowId)).thenThrow(VendorNotFoundException.class);
        Mockito.when(usuarioService.getUserByUserId(userId)).thenReturn(followerUser);


        //Act and Assert
        Assertions.assertThrows(VendorNotFoundException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                followerService.followUser(followUserRequest);
            }
        });


    }


    //T 0002:
    @Test
    void testToUnfollowToUserWithExistentUserId(){

        //Arrange
        int userId = 1; //Id Existente
        int userToFollowId = 3; //Id existente
        DTOUsuario userFollower = new DTOUsuario();
        userFollower.setUserId(userId);
        DTOUsuario userToUnfollow = new DTOUsuario();
        userToUnfollow.setUserId(userToFollowId);
        DTOUnfollowUser unfollowRequest = new DTOUnfollowUser();
        unfollowRequest.setUserId(userId);
        unfollowRequest.setUserIdToUnfollow(userToFollowId);
        ResponseEntity expectedResponse = new ResponseEntity<>(HttpStatus.OK);

        //Mock
        Mockito.when(usuarioService.getUserByUserId(userToFollowId)).thenReturn(userToUnfollow);
        Mockito.when(usuarioService.getUserByUserId(userId)).thenReturn(userFollower);


        //Act
        ResponseEntity response = followerService.unFollowUser(unfollowRequest);

        verify(usuarioService, atLeastOnce()).getUserByUserId(userToFollowId);
        verify(usuarioService, atLeastOnce()).getUserByUserId(userId);

        //Assert
        Assertions.assertEquals(expectedResponse, response);


    }

    @Test
    void testToUnfollowUnexistentUserCausingVendorNotFoundException(){

        //Arrange
        int userId = 1;
        int userToUnfollowId = 10; //Este userId no existe
        DTOUsuario userFollower = new DTOUsuario();
        userFollower.setUserId(userId);
        DTOUsuario userToFollow = new DTOUsuario();
        userToFollow.setUserId(userToUnfollowId);
        DTOUnfollowUser followUserRequest = new DTOUnfollowUser();
        followUserRequest.setUserId(userId);
        followUserRequest.setUserIdToUnfollow(userToUnfollowId);
        VendorNotFoundException expectedResponse = new VendorNotFoundException();

        //Mock
       // Mockito.when(usuarioService.getUserByUserId(userToUnfollowId)).thenThrow(VendorNotFoundException.class);
        Mockito.when(usuarioService.getUserByUserId(userToUnfollowId)).thenReturn(null); //Ambos metodos son validos
        Mockito.when(usuarioService.getUserByUserId(userId)).thenReturn(userFollower);



        //Act and Assert
        Assertions.assertThrows(VendorNotFoundException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                followerService.unFollowUser(followUserRequest);
            }
        });

        verify(usuarioService, atLeastOnce()).getUserByUserId(userToUnfollowId);
        verify(usuarioService, atLeastOnce()).getUserByUserId(userId);


    }


    //T 0007
    @Test
    void testToCountUserFollowersWithCorrectSumAndExistingUser(){

        //Arrange
        int userId = 3;
        List usersFollowers = new ArrayList();

        Usuarios followedUser = new Usuarios();
        followedUser.setUserName("vendedor3");
        followedUser.setId(userId);

        DTOUsuario followedUserDTO = UsuarioMapper.UsuarioTODtoUsuario(followedUser);

        Usuarios followerUser1 = new Usuarios();
        Usuarios followerUser2 = new Usuarios();
        Usuarios followerUser3 = new Usuarios();

        usersFollowers.add(followerUser1);
        usersFollowers.add(followerUser2);
        usersFollowers.add(followerUser3);

        DTOUserId request = new DTOUserId(userId);
        DTOUserFollowerCount response = new DTOUserFollowerCount();


        //Mock
        Mockito.when(usuarioService.getUserByUserId(userId)).thenReturn(followedUserDTO);
        Mockito.when(followerRepository.getUsersWhoFollowsToUserId(userId,null)).thenReturn(usersFollowers);

        //Act
        response = followerService.getFollowersCountByUserID(request);

        verify(usuarioService, atLeastOnce()).getUserByUserId(userId);
        verify(followerRepository, atLeastOnce()).getUsersWhoFollowsToUserId(userId,null);

        //Assert
        Assertions.assertEquals(3, response.getFollowersCount());

    }





}
