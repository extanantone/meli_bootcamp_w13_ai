package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;

public interface IUserRepository {



    public void follow(User userId, User userIdToFollow);

    User validateFollow(User userId, User userIdToFollow);

    public User findById(Integer userId);

    void unFollow(User userId, User userIdToUnfollow);
}
