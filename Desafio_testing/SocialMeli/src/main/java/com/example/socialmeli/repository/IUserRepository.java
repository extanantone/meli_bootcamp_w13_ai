package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;

import java.util.Optional;

public interface IUserRepository {



    public void follow(User userId, User userIdToFollow);

    Optional<User> validateFollow(User userId, User userIdToFollow);

    public Optional<User> findById(Integer userId);

    void unFollow(User userId, User userIdToUnfollow);
}
