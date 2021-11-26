package com.bootcamp.SocialMeli.unitari.service;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.mapper.UserMapper;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import com.bootcamp.SocialMeli.service.UserServicie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServicieTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserServicie service;
    //Arrange
    User userSeguidor = new User(1,"Juan");
    User userSeguido = new User(2,"Pedro");
    User userOrder1 = new User(3,"Dan");
    User userOrder2 = new User(4,"Len");
    int idSeguidor = 1;
    int idSeguido = 2;
    List<Seguidor>  seguidors = new ArrayList<>();
    {
        seguidors.add(new Seguidor(1,2));
        seguidors.add(new Seguidor(1,3));
        seguidors.add(new Seguidor(2,3));
        seguidors.add(new Seguidor(3,2));
    }


    ModelMapper mapper = new ModelMapper();
    //T-0001 -1
    @Test
    void whenSetSeguidoridSeguidoThenidSeguidoOK(){

        //Moks
        Mockito.when(repository.getUser(idSeguidor)).thenReturn(userSeguidor);
        Mockito.when(repository.getUser(idSeguido)).thenReturn(userSeguido);

        //Act

        SeguidorDTO seguidorDTO = service.setSeguidor(idSeguidor,idSeguido);

        //Assert
        Assertions.assertAll(
                ()-> Assertions.assertEquals(1,seguidorDTO.getIdSeguidor()),
                ()-> Assertions.assertEquals("Juan",seguidorDTO.getNameSeguidor()),
                ()-> Assertions.assertEquals(2,seguidorDTO.getIdSeguido()),
                ()-> Assertions.assertEquals("Pedro",seguidorDTO.getNameSeguido())
        );
    }

    //T-0001 -2
    @Test
    void whenSetSeguidoridSeguidoThenidSeguidoNoExits(){
        //Mocks
        Mockito.when(repository.getUser(2)).thenReturn(null);
        Mockito.when(repository.getUser(1)).thenReturn(userSeguidor);

        //Assert
        Assertions.assertThrows(NotFoundExceptionUsers.class,()-> service.setSeguidor(1,2));
    }

    //T-0002 -1
    @Test
    void whenDejarDeSeguirThenDejarDeSeguirOK(){

        //Moks
        Mockito.when(repository.getUser(idSeguidor)).thenReturn(userSeguidor);
        Mockito.when(repository.getUser(idSeguido)).thenReturn(userSeguido);

        //Act

        SeguidorDTO seguidorDTO = service.dejarDeSeguir(idSeguidor,idSeguido);

        //Assert
        Assertions.assertAll(
                ()-> Assertions.assertEquals(1,seguidorDTO.getIdSeguidor()),
                ()-> Assertions.assertEquals("",seguidorDTO.getNameSeguidor()),
                ()-> Assertions.assertEquals(2,seguidorDTO.getIdSeguido()),
                ()-> Assertions.assertEquals("",seguidorDTO.getNameSeguido())
        );
    }

    //T-0002 -2
    @Test
    void whenDejarDeSeguirThenDejarDeSeguirExection(){

        //Mocks
        Mockito.when(repository.getUser(2)).thenReturn(null);
        Mockito.when(repository.getUser(1)).thenReturn(userSeguidor);

        //Assert
        Assertions.assertThrows(NotFoundExceptionUsers.class,()-> service.dejarDeSeguir(1,2));

    }

    //T-0004 -1
    @Test
    void whengetOrdenadaname_ascOK(){
        MesiguenDTO mesiguenDTO = new MesiguenDTO();
        mesiguenDTO.setUser_id(userSeguido.getUserId());
        mesiguenDTO.setUser_name(userSeguido.getUserName());
        List<UserDTO> userDTOS = Arrays.asList(UserMapper.userToUserDTO(userSeguidor),UserMapper.userToUserDTO(userOrder1));
        mesiguenDTO.setFollowers(userDTOS);

        //Mocks
        Mockito.when(repository.getSegidor()).thenReturn(seguidors);
        Mockito.when(repository.getUser(2)).thenReturn(userSeguido);
        Mockito.when(repository.getUser(1)).thenReturn(userSeguidor);
        Mockito.when(repository.getUser(3)).thenReturn(userOrder1);

        MesiguenDTO expect = service.getOrdenadaMesiguen(userSeguido.getUserId(),"name_asc");

        //Assert
        Assertions.assertAll(
                ()-> Assertions.assertEquals(1, mesiguenDTO.getFollowers().get(0).getUserId()),
                ()-> Assertions.assertEquals(3, mesiguenDTO.getFollowers().get(1).getUserId())
        );

    }

    //T-0004 -2
    @Test
    void whengetOrdenadaname_decOK(){
        MesiguenDTO mesiguenDTO = new MesiguenDTO();
        mesiguenDTO.setUser_id(userSeguido.getUserId());
        mesiguenDTO.setUser_name(userSeguido.getUserName());
        List<UserDTO> userDTOS = Arrays.asList(UserMapper.userToUserDTO(userOrder1),UserMapper.userToUserDTO(userSeguidor));
        mesiguenDTO.setFollowers(userDTOS);

        List<UserDTO> pru = Arrays.asList(mapper.map(userOrder1,UserDTO.class),mapper.map(userSeguidor,UserDTO.class));

        //Mocks
        Mockito.when(repository.getSegidor()).thenReturn(seguidors);
        Mockito.when(repository.getUser(2)).thenReturn(userSeguido);
        Mockito.when(repository.getUser(1)).thenReturn(userSeguidor);
        Mockito.when(repository.getUser(3)).thenReturn(userOrder1);

        MesiguenDTO expect = service.getOrdenadaMesiguen(userSeguido.getUserId(),"name_asc");

        //Assert
        Assertions.assertAll(
                ()-> Assertions.assertEquals(3, mesiguenDTO.getFollowers().get(0).getUserId()),
                ()-> Assertions.assertEquals(1, mesiguenDTO.getFollowers().get(1).getUserId())
        );

    }

    //T-0007
    @Test
    void whengetSequidoresThenQuantitySeguidores(){

        //Arrange
        MesiguenCabtidadDTO expected = new MesiguenCabtidadDTO(userSeguido.getUserId(),userSeguido.getUserName(),2);
        //Mocks
         Mockito.when(repository.getSegidor()).thenReturn(seguidors);
         Mockito.when(repository.getUser(2)).thenReturn(userSeguido);
        //Act
        MesiguenCabtidadDTO current = service.getSequidores(2);
        //Assert

        Assertions.assertEquals(2,current.getFollowers_count());


    }








}
