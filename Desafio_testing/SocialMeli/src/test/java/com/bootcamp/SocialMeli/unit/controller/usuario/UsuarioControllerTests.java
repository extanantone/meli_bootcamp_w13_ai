package com.bootcamp.SocialMeli.unit.controller.usuario;

import com.bootcamp.SocialMeli.controller.*;
import com.bootcamp.SocialMeli.exception.ExceptionSocialMeliHandler;
import com.bootcamp.SocialMeli.service.usuario.IUsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTests {
    @Mock
    private IUsuarioService service;

    @InjectMocks
    private UsuarioController controller;



    private ExceptionSocialMeliHandler exceptionHandlerController = new ExceptionSocialMeliHandler();

    @Test
    public void followExistentUser(){
        // Arrange


        // Act


        // Assert
    }

    @Test
    public void followNonExistentUser(){

    }

}
