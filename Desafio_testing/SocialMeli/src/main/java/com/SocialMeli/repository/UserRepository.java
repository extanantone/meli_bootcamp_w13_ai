package com.SocialMeli.repository;

import com.SocialMeli.model.Post;
import com.SocialMeli.model.PromoPost;
import com.SocialMeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryI {
    private final HashMap<Integer, User> usersList = new HashMap<>();
    private final HashMap<Integer, Post> postsList = new HashMap<>();
    private final HashMap<Integer, PromoPost> promoPostsList = new HashMap<>();

    public UserRepository() {
        for (User u : loadDataBase()) {
            usersList.put(u.getId(), u);
        }
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
        List<User> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


    @Override
    public HashMap<Integer, User> getUsers() {
        return usersList;
    }

    @Override
    public HashMap<Integer, Post> getPosts() {
        return postsList;
    }

    @Override
    public HashMap<Integer, PromoPost> getPromoPosts() {
        return promoPostsList;
    }

    @Override
    public void addUser(User newUser) {
        usersList.put(newUser.getId(), newUser);
    }

    @Override
    public void addPost(Post newPost) {
        postsList.put(newPost.getIdPost(), newPost);
    }

    @Override
    public void addPromoPost(PromoPost newPromoPost) {
        promoPostsList.put(newPromoPost.getIdPost(), newPromoPost);
    }

}
