package com.example.socialmeli.unit.repository;

import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.IRepository;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTests {
    IRepository userRepository;

    public UserRepositoryTests() throws JsonProcessingException {
        //setUp, no va en método @BeforeAll por restricción de static
        this.userRepository = new UsuarioRepository();
        restoreUsersFile();
    }

    @Test
    public void findByIdTestExistingUser() {

        User manuel = (User) userRepository.findById(3).get();

        assertAll(
                () -> assertEquals(manuel.getUserId(), 3),
                () -> assertEquals(manuel.getUserName(), "Fede"),
                () -> assertTrue(manuel.getFollowersId().isEmpty())
        );
    }

    @Test
    public void findByIdTestNonExistingUser() {

        Optional<User> manuel = userRepository.findById(123);

        assertTrue(manuel.isEmpty());
    }
}
