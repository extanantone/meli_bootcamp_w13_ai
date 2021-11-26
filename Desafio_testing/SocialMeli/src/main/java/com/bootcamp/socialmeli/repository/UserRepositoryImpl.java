package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.InternalServerError;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    private Map<Long, User> users;

    private Long counter;

    public UserRepositoryImpl() {
        this.counter = 1L;
        this.users = loadDataBase();
    }

    @Override
    public User getUser(Long userId) {
        return users.get(userId);
    }

    @Override
    public Long saveUser(User newUser) {
        Long newId = this.counter;
        this.counter++;
        newUser.setUserId(newId);
        this.users.put(newId, newUser);
        return newId;
    }

    @Override
    public List<User> getAllUsers() {
        return new LinkedList<>(this.users.values());
    }

    @Override
    public boolean follow(User followerID, User followedID) {
        if(this.users.get(followedID.getUserId()).addFollower(followerID)){
            if(this.users.get(followerID.getUserId()).addFollowed(followedID)){
                return true;
            } else {
                this.users.get(followedID.getUserId()).getFollowers().remove(followerID);
                throw new InternalServerError();
            }
        }
        throw new InternalServerError();
    }

    @Override
    public boolean unfollow(User followerID, User followedID) {
        if(this.users.get(followedID.getUserId()).removeFollower(followerID)){
            if(this.users.get(followerID.getUserId()).removeFollowed(followedID)){
                return true;
            } else {
                this.users.get(followedID.getUserId()).getFollowers().add(followerID);
                throw new InternalServerError();
            }
        }
        throw new InternalServerError();
    }

    private Map<Long, User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> usersDB = new ArrayList<>();
        try {
            usersDB = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Long, User> usersMap = new HashMap<>();
        for (User user : usersDB){
            user.setFollowers(new LinkedList<>());
            user.setFollowed(new LinkedList<>());
            usersMap.put(user.getUserId(), user);
            this.counter++;
        }
        return usersMap;
    }

    public void reloadDataBase(){
        this.users = loadDataBase();
        this.counter = this.users.size()+1L;
    }
}
