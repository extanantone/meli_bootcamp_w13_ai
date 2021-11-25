package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.User;

import java.util.List;

public interface IUserRepository {
    User getUser(Long userId);
    Long saveUser(User newUser);
    List<User> getAllUsers();
    boolean follow(User followerID, User followedID);
    boolean unfollow(User followerID, User followedID);
}
