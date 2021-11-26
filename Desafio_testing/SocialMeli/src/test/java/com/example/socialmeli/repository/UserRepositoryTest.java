package com.example.socialmeli.repository;

import com.example.socialmeli.exception.UserIdNotFoundException;
import com.example.socialmeli.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    IUserRepository userRepository = new UserRepository();

    @Test
    void shouldFindExistingUser() {
        User user = userRepository.find(1);
        System.out.println("Should find existing user...");
        assertEquals(1, user.getId());
    }

    @Test
    void shouldThrowUserIdNotFoundException() {
        System.out.println("Should throw UserIdNotFoundException Exception...");
        assertThrows(UserIdNotFoundException.class, () -> userRepository.find(999));
    }

    @Test
    void shouldReturnAllPreexistingUsers() {
        Set<Map.Entry<Integer, User>> users = userRepository.findAll();
        assertEquals(8, users.size());
    }
}
