package com.bootcamp.SocialMeli.unit.service.usuario;

import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.usuario.IUsuarioRepository;
import com.bootcamp.SocialMeli.service.usuario.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTests {
    @Mock
    IUsuarioRepository repository;

    @InjectMocks
    UsuarioService service;

    @Test
    public void followWithExistentUserToExistentUser() {
        // Arrange
        Integer userIdFollower = 10;
        Integer userIdFollowed = 20;

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(new ArrayList<>());

        Usuario followed = new Usuario();
        followed.setUserId(userIdFollowed);
        followed.setFollowers(new ArrayList<>());

        // Act
        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(true);

        Mockito.when(repository.devolverUsuario(userIdFollower)).thenReturn(follower);
        Mockito.when(repository.devolverUsuario(userIdFollowed)).thenReturn(followed);

        service.realizarFollow(userIdFollower, userIdFollowed);

        verify(repository, atLeastOnce()).insertarFollower(userIdFollower, userIdFollowed);
        verify(repository, atLeastOnce()).insertarFollowed(userIdFollower, userIdFollowed);
    }

    @Test
    public void followWithExistentUserToNonExistentUser() throws BadRequestException {
        Integer userIdFollower = 10;
        Integer userIdFollowed = 20;

        Usuario follower = new Usuario();
        follower.setUserId(userIdFollower);
        follower.setFollowed(new ArrayList<>());

        Mockito.when(repository.encontrarUsuario(userIdFollower)).thenReturn(true);
        Mockito.when(repository.encontrarUsuario(userIdFollowed)).thenReturn(false);

        Assertions.assertThrows(BadRequestException.class, () -> service.realizarFollow(userIdFollower, userIdFollowed));
    }
}
