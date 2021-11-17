package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Detail;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{
    private final List<User> usersList;
    private Map<Integer, Post> posts = new HashMap<>();
    private Map<Integer, Detail> details = new HashMap<>();

    public UserRepository(List<User> usersList) {
        this.usersList = loadDataBase();
        System.out.println(this.usersList);
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public Optional<User> getUser(Integer userId){
        return this.usersList.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();
    }

    private List<User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        User user = usersList.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
        User userToFollow = usersList.stream()
                .filter(u -> u.getUserId().equals(userIdToFollow))
                .findFirst()
                .orElse(null);

        user.addFollowed(userToFollow);
        userToFollow.addFollower(user);
    }
}
