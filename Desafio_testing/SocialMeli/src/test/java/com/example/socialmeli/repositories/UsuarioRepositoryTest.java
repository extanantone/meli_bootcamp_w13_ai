package com.example.socialmeli.repositories;

import org.junit.jupiter.api.*;
import com.example.socialmeli.model.User;

import java.util.List;
import java.util.Optional;


public class UsuarioRepositoryTest {
    UsuarioRepository usuarioRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.usuarioRepository = new UsuarioRepository();
    }

    @Test
    @DisplayName("Buscamos un usuario por ID")
    void findUserById() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Leon Comprador");

        //Act
        Optional<User> userFound = usuarioRepository.findById(1);

        //Assert
        Assertions.assertEquals(user.getUserName(), userFound.get().getUserName());
    }

    @Test
    @DisplayName("Buscamos un usuario ID que no existe")
    void notFoundUserById() {
        //Arrange
        User user = new User();
        user.setUserId(6);
        user.setUserName("Leon Comprador");

        //Act
        Optional<User> userFound = usuarioRepository.findById(2);

        //Assert
        Assertions.assertNotEquals(user.getUserId(), userFound.get().getUserId());
        //Assertions.assertFalse(userFound.isPresent());
    }

    @Test
    @DisplayName("Buscamos un usuario creado sin datos")
    void notFoundUserByIdBecauseDoNotExist() {
        //Arrange
        User user = new User();

        //Act
        Optional<User> userFound = usuarioRepository.findById(user.getUserId());

        //Assert
        Assertions.assertTrue(userFound.isEmpty());
    }

    @Test
    void findAll() {
        //Arrange
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        List<User> users;

        //Act
        List<User> usersFounds = usuarioRepository.findAll();
        //Assert
    }

}
