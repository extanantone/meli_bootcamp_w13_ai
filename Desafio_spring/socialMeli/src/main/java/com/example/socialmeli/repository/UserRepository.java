package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Integer, User> users = new HashMap<Integer,User>();

    private List<User> database;

    public UserRepository() {
        User user1 = new User("Santiago");
        User user2 = new User("Sofia");
        User user3 = new User("Tomas");
        User user4 = new User("Jeison");
        users.put(user1.getUser_id(),user1);
        users.put(user2.getUser_id(),user2);
        users.put(user3.getUser_id(),user3);
        users.put(user4.getUser_id(),user4);



//        this.database = loadDataBase();
//        database.forEach(uss ->{
//            this.users.put(uss.getUser_id(),uss);
//        });
    }

    public User getUser(Integer user_id) {
        return this.users.get(user_id);
    }

    public void addUser(User user){
        this.users.put(user.getUser_id(),user);
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

    public Map<Integer, User> getUsers() {
        return users;
    }

    public boolean userExist (Integer user_id){
        return this.users.containsKey(user_id);
    }
}
