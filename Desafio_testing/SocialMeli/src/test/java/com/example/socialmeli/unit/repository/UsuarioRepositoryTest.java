package com.example.socialmeli.unit.repository;

import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.IRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioRepositoryTest {
    IRepository repoUsuarios = new UsuarioRepository();

    @Test
    void findByIdExistingUser(){
        User user = (User) repoUsuarios.findById(2).get();

        assertAll(
                () -> assertEquals(2,user.getUserId()),
                () -> assertEquals("Juan Comprador",user.getUserName()),
                () -> assertTrue(user.getFollowersId().isEmpty())
        );
    }

    @Test
    void findByIdNonExistingUser(){
        Optional<User> userNonExistingId = repoUsuarios.findById(909);
        assertTrue(userNonExistingId.isEmpty());
    }


}
