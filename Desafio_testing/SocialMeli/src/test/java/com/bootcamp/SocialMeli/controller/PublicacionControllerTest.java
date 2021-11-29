package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.Controller.PublicacionController;
import com.bootcamp.SocialMeli.DTO.DetallePublicacionDTO;
import com.bootcamp.SocialMeli.DTO.PublicUserDTO;
import com.bootcamp.SocialMeli.DTO.PublicacionDTO;
import com.bootcamp.SocialMeli.DTO.SeguidoresDTO;
import com.bootcamp.SocialMeli.Exception.NotFoundException;
import com.bootcamp.SocialMeli.Mapper.SocialMapper;
import com.bootcamp.SocialMeli.Model.DetallePublicacion;
import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Service.ISocialService;
import com.bootcamp.SocialMeli.service.SocialServiceTest;
import lombok.val;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PublicacionControllerTest {
    @Mock
    ISocialService socialService;

    @InjectMocks
    PublicacionController publicController;


    @Test
    @DisplayName(value="Trae una publicacion existente")
    public void getPublicExist(){
        //arrange
        PublicUserDTO expect = new PublicUserDTO();
        ResponseEntity<PublicUserDTO> responseEntity = new ResponseEntity<>(expect, HttpStatus.OK);
        //Mocks
        Mockito.when(socialService.getPubliOrderByFecha(3,"name_asc")).thenReturn(expect);

        //Assert
        Assertions.assertEquals(responseEntity, publicController.getPublic(3,"name_asc"));
    }

    @Test
    @DisplayName(value="Cuando no existe una publicación")
    public void getPublicByUserIDNotExist(){
        //arrange
        PublicUserDTO expect = new PublicUserDTO();
        //Mocks
        Mockito.when(socialService.getPubliOrderByFecha(5,"name_asc")).thenThrow(NotFoundException.class);

        //Assert
        Assertions.assertThrows(NotFoundException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                publicController.getPublic(5,"name_asc");
            }
        });

    }

    @Test
    @DisplayName(value="Añadir un post")
    public void addNewPublic(){
        //arrange
        DetallePublicacionDTO det1= new DetallePublicacionDTO(1,"Camiseta","Ropa","Sport","Azul","Slim");
        PublicacionDTO pub1= new PublicacionDTO(3,1,LocalDate.of(2021,11,26),det1,100,15000.00);
        List<PublicacionDTO> list = new ArrayList<>();
        list.add(pub1);
        PublicUserDTO expect = new PublicUserDTO();
        expect.setUserId(3);
        expect.setPosts(list);
        //Mocks
        Mockito.when(socialService.setPublicacion(expect.getPosts().get(0))).thenReturn(expect.getPosts().get(0));
        //Act
        ResponseEntity<PublicUserDTO> responseExpect = new ResponseEntity<>(expect, HttpStatus.OK);
        ResponseEntity<PublicUserDTO> responseCurrent = publicController.addNewPublic(expect.getPosts().get(0));
        //Assert
        System.out.println("----------------------Resultado esperado------------------");
        System.out.println(responseExpect.getStatusCode());
        System.out.println("----------------------Resultado obtenido------------------");
        System.out.println(responseCurrent.getStatusCode());
        Assertions.assertEquals(responseExpect.getStatusCode(), responseCurrent.getStatusCode());
    }


}
