package com.lgoyenechea.socialmeli.repository;

import com.lgoyenechea.socialmeli.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @InjectMocks
    UserRepository userRepository;

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void givenCorrectUser_whenSave_thenSaveOk() {
        userRepository.save(user);
        assertEquals(user.getId(), 1L);
    }

    @Test
    void givenCorrectUserId_whenGetById_thenReturnUser() {
        userRepository.save(user);
        User response = userRepository.getById(1L);
        assertEquals(user, response);
    }

    @Test
    void givenIncorrectUserId_whenGetById_thenNull() {
        User response = userRepository.getById(1L);
        assertNull(response);
    }

    @Test
    void givenCorrectUserId_whenExistsById_thenReturnTrue() {
        userRepository.save(user);
        assertTrue(userRepository.existsById(1L));
    }

    @Test
    void givenIncorrectUserId_whenExistsById_thenReturnFalse() {
        assertFalse(userRepository.existsById(1L));
    }
}