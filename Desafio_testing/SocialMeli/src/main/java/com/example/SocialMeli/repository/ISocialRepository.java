package com.example.SocialMeli.repository;

import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;

import java.util.List;
import java.util.Optional;

public interface ISocialRepository {
    void followUser(User user, User userToFollow);
    void unfollowUser(User user, User userToUnfollow);
    List<User> getUsers();
    void createPublication(User user, Publication publication);
    Optional<User> findUser(int userId);

}
