package com.example.socialmeli.unit.repository;

import com.example.socialmeli.TestUtilsFileHandling;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.IRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.TestUtilsGet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTests {
    IRepository usuarioRepository;

    public UserRepositoryTests() {
        //setUp, no va en método @BeforeAll por restricción de static
        this.usuarioRepository = new UsuarioRepository();
    }

    @BeforeEach
    private void cleanUp() throws JsonProcessingException {
        TestUtilsFileHandling.restoreUsersFile();
    }

    @AfterAll
    private static void emptyRepository() {
        TestUtilsFileHandling.emptyUsersFile();
    }

    @Test
    public void findByIdTestExistingUser() {

        User manuel = (User) usuarioRepository.findById(3).get();

        assertAll(
                () -> assertEquals(manuel.getUserId(), 3),
                () -> assertEquals(manuel.getUserName(), "Fede"),
                () -> assertTrue(manuel.getFollowersId().isEmpty())
        );
    }

    @Test
    public void findByIdTestNonExistingUser() {

        Optional<User> manuel = usuarioRepository.findById(123);

        assertTrue(manuel.isEmpty());
    }
}
