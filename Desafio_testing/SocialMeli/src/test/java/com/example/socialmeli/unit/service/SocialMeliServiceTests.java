package com.example.socialmeli.unit.service;

import com.example.socialmeli.TestUtilsGenerator;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.IRepository;
import com.example.socialmeli.repositories.PostRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.services.IService;
import com.example.socialmeli.services.SocialMeliService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTests {
    @Mock
    UsuarioRepository usuarioRepository;
    @Mock
    PostRepository postRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

    @Test
    public void findByIdTestExistingUser() throws UserNotFoundException {

        User manuel = new User();
        manuel.setUserId(3);
        manuel.setUserName("Manuel Vendedor");
        when(usuarioRepository.findById(3)).thenReturn(Optional.of(manuel));

        User response = socialMeliService.getUserById(3);

        verify(usuarioRepository, atLeastOnce()).findById(3);
        assertEquals(response, manuel);

    }

    @Test
    public void findByIdTestNonExistingUser() throws UserNotFoundException {
        when(usuarioRepository.findById(any())).thenReturn(Optional.empty());

        Throwable exception = assertThrows(UserNotFoundException.class, () -> socialMeliService.getUserById(123));

        verify(usuarioRepository, atLeastOnce()).findById(123);
        assertEquals(UserNotFoundException.class, exception.getClass());


    }
}
