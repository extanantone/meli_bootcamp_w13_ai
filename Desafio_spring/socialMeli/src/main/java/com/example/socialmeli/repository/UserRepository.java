package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Integer, User> users = new HashMap<Integer,User>();

    private List<User> database;

    public UserRepository() {
        User user2 = new User("Sofia");
        User user3 = new User("Tomas");
        User user4 = new User("Andres");
        User user1 = new User("Santiago");

        user2.setUserFollowed(2);
        user2.setUserFollowed(3);

        user2.setUserFollowed(4);

        users.put(user1.getUserId(),user1);
        users.put(user2.getUserId(),user2);
        users.put(user3.getUserId(),user3);
        users.put(user4.getUserId(),user4);



//        this.database = loadDataBase();
//        database.forEach(uss ->{
//            this.users.put(uss.getUserId(),uss);
//        });
    }

    public User getUser(Integer userId) {
        return this.users.get(userId);
    }

    public void addUser(User user){
        this.users.put(user.getUserId(),user);
    }

    private List<User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
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

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        this.users.forEach((k,u) ->{
            userList.add(u);
        });
        return userList;
    }

    public boolean userExist (Integer userId){
        return this.users.containsKey(userId);
    }
}
