package com.example.socialmeli.demo.unittest.repository;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.mapper.UsuarioMapper;
import com.example.socialmeli.demo.model.Usuarios;
import com.example.socialmeli.demo.repository.FollowerRepository;
import com.example.socialmeli.demo.repository.IFollowerRepository;
import com.example.socialmeli.demo.repository.IUserRepository;
import com.example.socialmeli.demo.repository.UserRepository;
import com.example.socialmeli.demo.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FollowerRepositoryTest {


    @Mock
    UserRepository usuarioRepository;

    @InjectMocks
    FollowerRepository followerRepository;



    //T 0003
    //Este test va a fallar, ya que en mi sistema, que el order sea null no provoca que se arroje una excepcion
    @Test
    void testThatPassingANullAlphabetOrderThrowsARunTimeException(){

        //Arrange
        int userId = 1;
        String order = null;

        //Act and Assert
        Assertions.assertThrows(RuntimeException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                List<Usuarios> response = followerRepository.getUsersFollowedByUserId(userId,order);
            }
        });

    }

    @Test
    void testThatPassingAValidAlphabetOrderAllowsToExecuteOrderNormally() {

        //Arrange
        int userId = 1;
        String order = "name_asc";

        //Act
        List<Usuarios> response = followerRepository.getUsersFollowedByUserId(userId, order);

        //Assert
        Assertions.assertEquals(0,response.size());

    }


    //T 0004
    @Test
    void testThatFollowedUsersAreCorrectlySortedInDescendingOrderByUserName(){

        //Arrange
        int userId = 1;
        String order = "name_desc";

        //Initialice users
        Usuarios user1 = new Usuarios();
        user1.setId(1);
        user1.setUserName("comprador1");

        Usuarios vendor1 = new Usuarios();
        vendor1.setId(3);
        vendor1.setUserName("vendedor3");
        Usuarios vendor2 = new Usuarios();
        vendor2.setId(4);
        vendor2.setUserName("vendedor4");

        //Request to follow users
        DTOFollowUser request = new DTOFollowUser();
        request.setUserId(user1.getId());

        List<Usuarios> expectedSortedFollowedUsers = new ArrayList<>();
        expectedSortedFollowedUsers.add(vendor2);
        expectedSortedFollowedUsers.add(vendor1);

        Mockito.when(usuarioRepository.getUserByUserId(3)).thenReturn(vendor1);
        Mockito.when(usuarioRepository.getUserByUserId(4)).thenReturn(vendor2);

        //Act
        request.setUserIdToFollow(vendor1.getId());
        followerRepository.FollowUser(request);
        request.setUserIdToFollow(vendor2.getId());
        followerRepository.FollowUser(request);

        List<Usuarios> response = followerRepository.getUsersFollowedByUserId(userId,order);

        verify(usuarioRepository, atLeastOnce()).getUserByUserId(3);
        verify(usuarioRepository, atLeastOnce()).getUserByUserId(4);

        //Assert
        Assertions.assertEquals(expectedSortedFollowedUsers,response);

    }

    @Test
    void testThatFollowedUsersAreCorrectlySortedInAscendingOrderByUserName(){

        //Arrange
        int userId = 1;
        String order = "name_asc";

        //Initialice users
        Usuarios user1 = new Usuarios();
        user1.setId(1);
        user1.setUserName("comprador1");

        Usuarios vendor1 = new Usuarios();
        vendor1.setId(3);
        vendor1.setUserName("vendedor3");
        Usuarios vendor2 = new Usuarios();
        vendor2.setId(4);
        vendor2.setUserName("vendedor4");

        //Request to follow users
        DTOFollowUser request = new DTOFollowUser();
        request.setUserId(user1.getId());

        List<Usuarios> expectedSortedFollowedUsers = new ArrayList<>();
        expectedSortedFollowedUsers.add(vendor1);
        expectedSortedFollowedUsers.add(vendor2);

        Mockito.when(usuarioRepository.getUserByUserId(3)).thenReturn(vendor1);
        Mockito.when(usuarioRepository.getUserByUserId(4)).thenReturn(vendor2);

        //Act
        request.setUserIdToFollow(vendor1.getId());
        followerRepository.FollowUser(request);
        request.setUserIdToFollow(vendor2.getId());
        followerRepository.FollowUser(request);

        List<Usuarios> response = followerRepository.getUsersFollowedByUserId(userId,order);

        verify(usuarioRepository, atLeastOnce()).getUserByUserId(3);
        verify(usuarioRepository, atLeastOnce()).getUserByUserId(4);

        //Assert
        Assertions.assertEquals(expectedSortedFollowedUsers,response);

    }



}
