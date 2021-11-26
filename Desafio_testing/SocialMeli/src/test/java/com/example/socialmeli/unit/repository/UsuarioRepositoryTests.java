package com.example.socialmeli.unit.repository;

import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.IRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.example.socialmeli.TestUtilsGenerator;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioRepositoryTests {
    IRepository usuarioRepository;

    public UsuarioRepositoryTests() {
        //setUp, no va en método @BeforeAll por restricción de static
        this.usuarioRepository = new UsuarioRepository();
    }

    @AfterAll
    private static void cleanUp() {
        TestUtilsGenerator.restoreUsersFile();
    }

    @BeforeEach
    private void emptyRepository() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void findByIdTestExistingUser() {

        User manuel = (User) usuarioRepository.findById(3).get();

        assertAll(
                () -> assertEquals(manuel.getUserId(), 3),
                () -> assertEquals(manuel.getUserName(), "Manuel Vendedor"),
                () -> assertTrue(manuel.getFollowersId().isEmpty())
        );
    }

    @Test
    public void findByIdTestNonExistingUser() {

        Optional<User> manuel = usuarioRepository.findById(123);

        assertTrue(manuel.isEmpty());
    }
}
