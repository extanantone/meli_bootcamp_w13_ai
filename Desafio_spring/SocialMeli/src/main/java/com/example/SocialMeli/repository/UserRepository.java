package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.User;

import java.util.List;

public interface UserRepository {

    Boolean saveFollow(int id, int toFollow);

    User getById(int id);

    List<User> getFollowers(int id) throws Exception;
}
