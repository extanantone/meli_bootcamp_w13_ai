package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    User getUser(int id);

    void followUser(User user, User userToFollow);

    int getTotalUserFollowers(User user);

    List<User> getUsersFollowed(User user);

    List <User> getUsersFollowers(int id);

    void unfollowUser(User user, User userToUnfollow);
}
