package com.socialmeli.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private Map<Integer, User> repository = new HashMap<>();
    private Integer counter;

    public UserRepository() {

        this.repository = loadDataBase();
        this.counter = repository.size();
    }

    private Map<Integer, User> loadDataBase() {
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

        return  users.stream().collect(Collectors.toMap(User::getUserId, Function.identity()));
    }

    @Override
    public User createUser(User user) {

        this.counter += 1;
        user.setUserId(this.counter);
        this.repository.put(counter, user);

        return user;
    }

    @Override
    public User findUserById(Integer id) {
        return this.repository.get(id);
    }

    @Override
    public List<User> getUsers() {
        return this.repository.entrySet().stream().map(e -> {
            e.getValue().setUserId(e.getKey());
            return e.getValue();
        }).collect(Collectors.toList());
    }
}
