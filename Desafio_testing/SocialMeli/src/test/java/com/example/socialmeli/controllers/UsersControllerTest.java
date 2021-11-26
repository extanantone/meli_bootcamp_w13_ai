package com.example.socialmeli.controllers;

import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

    @Mock
    SocialMeliService socialMeliService;

    @InjectMocks
    UsersController usersController;
}
