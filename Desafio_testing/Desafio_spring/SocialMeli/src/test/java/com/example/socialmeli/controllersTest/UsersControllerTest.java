package com.example.socialmeli.controllersTest;

import com.example.socialmeli.controllers.UsersController;
import com.example.socialmeli.exceptions.UserAlreadyInUseException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.UserSelfUseException;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.TestCase.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {
    @Mock
    private SocialMeliService service;
    @InjectMocks
    private UsersController controlador;



}
