package com.example.SocialMeli.repository;

import com.example.SocialMeli.exceptions.*;
import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class SocialRepository implements ISocialRepository{

    List<User> usuarios;

    public SocialRepository() {
        this.usuarios = loadUsers();
    }

    protected List<User> loadUsers(){
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
    public void followUser(User user, User userToFollow) {
        user.addFollowed(userToFollow);
        userToFollow.addFollower(user);
    }

    @Override
    public void unfollowUser(User user, User userToUnfollow) {
        user.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(user);
    }

    @Override
    public void createPublication(User user, Publication publication) {
        user.addPublication(publication);
    }

    @Override
    public Optional<User> findUser(int userId) {
        return this.usuarios.stream()
                .filter(u -> u.getUserId()==userId)
                .findFirst();
    }

    @Override
    public List<User> getUsers() {
        return usuarios;
    }
}
