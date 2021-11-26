package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    User createUser(String name);

    User getUser(int id) throws NotPossibleOperationException;

    void followUser(User user, User userToFollow) throws NotPossibleOperationException;

    int getTotalUserFollowers(User user) throws NotPossibleOperationException;

    List<User> getUsersFollowed(User user) throws NotPossibleOperationException;

    List <User> getUsersFollowers(int id) throws NotPossibleOperationException;

    void unfollowUser(User user, User userToUnfollow) throws NotPossibleOperationException;
}
