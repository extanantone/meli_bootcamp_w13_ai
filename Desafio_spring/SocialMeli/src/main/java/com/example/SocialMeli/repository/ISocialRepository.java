package com.example.SocialMeli.repository;

import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;

import java.util.List;
import java.util.Optional;

public interface ISocialRepository {
    User getUser(int userId);
    void followUser(int userId, int userIdToFollow);
    void unfollowUser(int userId, int userIdToUnfollow);
    List<User> getUsers();
    void createPublication(int userId, Publication publication);


}
