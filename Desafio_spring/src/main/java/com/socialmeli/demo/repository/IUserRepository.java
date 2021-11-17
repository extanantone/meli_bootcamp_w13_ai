package com.socialmeli.demo.repository;

import com.socialmeli.demo.model.User;

import java.util.List;

public interface IUserRepository {

    public User createUser(User user);
    public User findUserById(Integer id);
    public List<User> getUsers();
}
