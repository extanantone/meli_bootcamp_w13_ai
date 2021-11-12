package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    public List<User> getAll();
    public User getUser(long id);
    public User createUser(User user);
    public boolean deleteUser(long id);
    public void followUser(long followerId, long followedId);
}
