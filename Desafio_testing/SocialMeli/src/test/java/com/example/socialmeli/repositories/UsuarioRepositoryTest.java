package com.example.socialmeli.repositories;

import com.example.socialmeli.Util.TestUtilsGenerator;
import com.example.socialmeli.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioRepositoryTest {
    IRepository usuarioRepository;

    @AfterAll
    private static void cleanUp() {
        TestUtilsGenerator.restoreUsersFile();
    }

    @BeforeEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.usuarioRepository = new UsuarioRepository();
    }

    @Test
    public void UserExist() {
        TestUtilsGenerator.restoreUsersFile();

        User tef = (User) usuarioRepository.findById(3).get();

        assertEquals(tef.getUserId(), 3);
        assertEquals(tef.getUserName(), "Estefania Vendedor");
    }

    @Test
    public void UserNotExist(){
        TestUtilsGenerator.restoreUsersFile();

        Optional<User> benja = usuarioRepository.findById(5);
        Assertions.assertTrue(benja.isEmpty());
    }
}
