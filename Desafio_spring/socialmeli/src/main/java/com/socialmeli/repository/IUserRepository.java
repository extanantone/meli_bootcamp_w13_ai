package com.socialmeli.repository;

import com.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {
    User getUserById(int id);
    List<User> followedUser(User user);
}
