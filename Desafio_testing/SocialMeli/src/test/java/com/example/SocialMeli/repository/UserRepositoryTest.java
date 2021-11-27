package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        this.userRepository = new UserRepositoryImpl();
    }
}