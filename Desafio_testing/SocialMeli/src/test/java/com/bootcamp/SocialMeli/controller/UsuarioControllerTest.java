package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.Controller.UsuarioController;
import com.bootcamp.SocialMeli.DTO.SeguidorDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresCountDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresDTO;
import com.bootcamp.SocialMeli.DTO.UsuarioDTO;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Service.ISocialService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    @Mock
    ISocialService socialService;

    @InjectMocks
    UsuarioController userController;

    @AfterEach
    void inicializa(){
        Mockito.reset(socialService);
    }

    @Test
    @DisplayName(value="Seguir a un vendedor")
    public void Follow(){
        //arrange
        SeguidorDTO expect = new SeguidorDTO(1,null,3,null);
        Seguidor seguidor = new Seguidor(expect.getIdUser(),expect.getIdUserFollow());
        //Mocks
        Mockito.when(socialService.postSeguidor(seguidor)).thenReturn(expect);
        //Act
        ResponseEntity<Seguidor> responseExpect = new ResponseEntity<>(seguidor, HttpStatus.OK);
        ResponseEntity<SeguidorDTO> responseCurrent = userController.Follow(expect.getIdUser(),expect.getIdUserFollow());
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Dejar de seguir a un vendedor")
    public void unFollow(){
        //arrange
        SeguidorDTO expect = new SeguidorDTO(1,null,3,null);
        Seguidor seguidor = new Seguidor(expect.getIdUser(),expect.getIdUserFollow());
        //Mocks
        Mockito.when(socialService.unFollow(seguidor)).thenReturn(expect);
        //Act
        ResponseEntity<Seguidor> responseExpect = new ResponseEntity<>(seguidor, HttpStatus.OK);
        ResponseEntity<SeguidorDTO> responseCurrent = userController.unFollow(expect.getIdUser(),expect.getIdUserFollow());
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Contar los seguidores")
    public void followerCount(){
        //arrange
        SeguidoresCountDTO expect = new SeguidoresCountDTO(3,"Bootcamp",2);
        //Act
        ResponseEntity<SeguidoresCountDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidoresCountDTO> responseCurrent = userController.getCuentaSeguidores(expect.getUserId());
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Trae mis seguidores")
    public void getFollowers(){
        //arrange
        UsuarioDTO usuarioDTO=new UsuarioDTO(1,"Bootcamp");
        UsuarioDTO usuarioDTO1=new UsuarioDTO(2,"Pepe");
        List<UsuarioDTO> user=new ArrayList<>();
        user.add(usuarioDTO);
        user.add(usuarioDTO1);
        SeguidoresDTO expect = new SeguidoresDTO(3,"Mario",user);
        //Act
        ResponseEntity<SeguidoresDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidoresDTO> responseCurrent = userController.getMisSeguidores(expect.getUserId());
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Trae mis seguidos")
    public void getFollowed(){
        //arrange
        UsuarioDTO usuarioDTO=new UsuarioDTO(3,"Bootcamp");
        List<UsuarioDTO> user=new ArrayList<>();
        user.add(usuarioDTO);
        SeguidoresDTO expect = new SeguidoresDTO(1,"Mario",user);
        //Act
        ResponseEntity<SeguidoresDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidoresDTO> responseCurrent = userController.getMisSeguidos(expect.getUserId());
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Trae lista de seguidores ordenada por name_asc")
    public void getFollowersOrderByNameAsc(){
        //arrange
        SeguidorDTO expect = new SeguidorDTO();
        expect.setIdUser(3);
        //Act
        ResponseEntity<SeguidorDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidorDTO> responseCurrent = userController.getOrderFollowers(expect.getIdUser(),"name_asc");
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Trae lista de seguidores ordenada por name_desc")
    public void getFollowersOrderByNameDesc(){
        //arrange
        SeguidorDTO expect = new SeguidorDTO();
        expect.setIdUser(3);
        //Act
        ResponseEntity<SeguidorDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidorDTO> responseCurrent = userController.getOrderFollowers(expect.getIdUser(),"name_desc");
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Trae lista de mis seguidos ordenada por name_asc")
    public void getFollowedOrderByNameAsc(){
        //arrange
        SeguidorDTO expect = new SeguidorDTO();
        expect.setIdUser(1);
        //Act
        ResponseEntity<SeguidorDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidorDTO> responseCurrent = userController.getfollowed(expect.getIdUser(),"name_asc");
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }

    @Test
    @DisplayName(value="Trae lista de mis seguidos ordenada por name_desc")
    public void getFollowedOrderByNameDesc(){
        //arrange
        SeguidorDTO expect = new SeguidorDTO();
        expect.setIdUser(1);
        //Act
        ResponseEntity<SeguidorDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<SeguidorDTO> responseCurrent = userController.getfollowed(expect.getIdUser(),"name_desc");
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }
}
