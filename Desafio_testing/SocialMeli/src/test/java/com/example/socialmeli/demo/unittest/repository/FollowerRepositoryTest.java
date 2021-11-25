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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FollowerRepositoryTest {

    IFollowerRepository followerRepository;

    @Mock
    IUserRepository usuarioRepository = new UserRepository();


    @BeforeEach
    public void initialize(){
        this.followerRepository= new FollowerRepository();
    }


    //T 0003
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


    //T 0004
    @Test
    void testThatOrderInFollowedUsersExistsSendingAValidOrderString(){

        //Arrange
        int userId = 1;
        String order = "name_asc";

        Usuarios user1 = new Usuarios();
        user1.setId(1);
        user1.setUserName("comprador1");

        DTOFollowUser request = new DTOFollowUser();
        request.setUserId(user1.getId());

        Usuarios vendor1 = new Usuarios();
        vendor1.setId(3);
        vendor1.setUserName("vendedor3");
        Usuarios vendor2 = new Usuarios();
        vendor2.setId(4);
        vendor2.setUserName("vendedor4");

        DTOUsuario vendor1Dto = UsuarioMapper.UsuarioTODtoUsuario(vendor1);
        DTOUsuario vendor2Dto = UsuarioMapper.UsuarioTODtoUsuario(vendor2);

        List<Usuarios> sortedFollowedUsersFromUserId = new ArrayList<>();
        sortedFollowedUsersFromUserId.add(vendor1);
        sortedFollowedUsersFromUserId.add(vendor2);

        Mockito.when(usuarioRepository.getUserByUserId(3)).thenReturn(vendor1);

        //Act
        request.setUserIdToFollow(vendor1.getId());
        followerRepository.FollowUser(request);
        request.setUserIdToFollow(vendor2.getId());
        followerRepository.FollowUser(request);

        List<Usuarios> response = followerRepository.getUsersFollowedByUserId(userId,order);

        //Mock
        Assertions.assertEquals(sortedFollowedUsersFromUserId,response);

    }



}
