package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {
    User getUser(int id);
    boolean followUser(int userId, int userFollowedId);
    int getTotalUserFollowers(int userId);
    List<User> getUsersFollowed(int id);
    List <User> getUsersFollowers(int id);
    boolean unfollowUser(int userId, int userToUnfollowId);

}
