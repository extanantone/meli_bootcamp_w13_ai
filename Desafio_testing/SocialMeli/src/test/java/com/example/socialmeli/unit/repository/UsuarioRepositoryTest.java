package com.example.socialmeli.unit.repository;

import com.example.socialmeli.model.User;
import com.example.socialmeli.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioRepositoryTest {
    UsuarioRepository usuarioRepository = new UsuarioRepository();

    @BeforeEach
    public void setUp() {
    }

    @Test
    void userExist(){
        // Arrange
        Integer user_id = 11;
        User user = new User();
        user.setUserId(user_id);
        user.setUserName("Santiago");
        User expected = usuarioRepository.addUser(user);

//        User sellersDTO = repo.createSellers(userDTO);
        // Act
        User current = usuarioRepository.findById(user_id).get();

        // Assert
        Assertions.assertEquals(expected,current);
    }
}
