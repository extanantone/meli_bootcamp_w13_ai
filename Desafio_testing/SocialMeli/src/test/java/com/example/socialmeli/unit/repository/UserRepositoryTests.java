package com.example.socialmeli.unit.repository;

import static com.example.socialmeli.TestUtilsFileHandling.writeToUsersFile;
import static com.example.socialmeli.TestUtilsPreload.restoreUsersFile;
import static com.example.socialmeli.TestUtilsGet.getUnsortedUserList;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTests {
    UsuarioRepository userRepository;

    public UserRepositoryTests() throws JsonProcessingException {
        //setUp, no va en método @BeforeAll por restricción de static
        this.userRepository = new UsuarioRepository();
        restoreUsersFile();
    }

    @BeforeEach
    public void cleanUp() {
        this.userRepository.overwriteWith(getUnsortedUserList());
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

    @Test
    public void loadsDataCorrectlyFromFile() throws JsonProcessingException {

        User pivot = new User();
        pivot.setUserId(19);
        pivot.setUserName("Pivot");

        writeToUsersFile(List.of(pivot));

        this.userRepository.loadFromUsersFile();

        List<User> users = this.userRepository.findAll();
        User userInRepo = users.get(0);
        assertAll(
                () -> assertEquals(userInRepo.getUserId(), 19),
                () -> assertEquals(userInRepo.getUserName(), "Pivot"),
                () -> assertTrue(userInRepo.getFollowersId().isEmpty())
        );
    }
}
