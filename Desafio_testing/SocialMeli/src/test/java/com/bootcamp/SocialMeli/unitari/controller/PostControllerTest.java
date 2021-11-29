package com.bootcamp.SocialMeli.unitari.controller;

import com.bootcamp.SocialMeli.controller.PostController;
import com.bootcamp.SocialMeli.dto.PublicacionesDTO;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.service.IPostService;
import com.bootcamp.SocialMeli.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Mock
    IPostService service;

    @InjectMocks
    PostController controller;

}
