package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    private long currentId;
    private Map<Long, User> users;

    public UserRepository() {
        this.users = this.loadUsersFromJSON();
        this.currentId = users.size();
    }

    public Map<Long, User> loadUsersFromJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> userList = null;
        try {
            userList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUser(long id) {
        return users.get(id);
    }

    @Override
    public User createUser(User user) {
        user.setId(this.currentId);
        users.put(user.getId(), user);
        currentId += 1;
        return user;
    }

    @Override
    public boolean deleteUser(long id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public void followUser(long followerId, long followedId) {
        users.get(followerId).getFollowed().add(users.get(followedId));
        users.get(followedId).getFollowers().add(users.get(followerId));
    }
}
