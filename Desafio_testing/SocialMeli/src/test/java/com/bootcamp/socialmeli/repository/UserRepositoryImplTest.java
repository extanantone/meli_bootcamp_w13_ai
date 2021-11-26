package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryImplTest {

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @AfterEach
    void reloadDataBase(){
        userRepository.reloadDataBase();
    }

    @Test
    void findUserTest(){
        Long expected = 1L;
        User actual = userRepository.getUser(expected);
        Assertions.assertEquals(expected, actual.getUserId());
    }

    @Test
    void saveUserTest(){
        User expected = new User(null, "Ana", null, null);
        Long actual = userRepository.saveUser(expected);
        Assertions.assertNotNull(actual);
    }

    @Test
    void findAllUsersTest(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> expected = new ArrayList<>();
        try {
            expected = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (User user : expected){
            user.setFollowers(new LinkedList<>());
            user.setFollowed(new LinkedList<>());
        }
        List<User> actual = userRepository.getAllUsers();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void followTest(){
        User user1 = new User(1L, "juan", null, null);
        User user2 = new User(2L, "camilo", null, null);
        Assertions.assertTrue(userRepository.follow(user1,user2));
    }

    @Test
    void unfollowTest(){
        User user1 = new User(1L, "juan", null, null);
        User user2 = new User(2L, "camilo", null, null);
        userRepository.follow(user1, user2);
        Assertions.assertTrue(userRepository.unfollow(user1,user2));
    }
}
