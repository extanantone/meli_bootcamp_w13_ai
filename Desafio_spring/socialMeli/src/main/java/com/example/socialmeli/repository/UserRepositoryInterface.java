package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;
import java.util.List;

public interface UserRepositoryInterface {
    User getUser(Integer userId);
    void addUser(User user);
    List<User> loadDataBase();
    List<User> getUsers();
    boolean userExist (Integer userId);
}
