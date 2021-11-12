package com.example.SocialMeli.repository;

import com.example.SocialMeli.entities.User;

public interface UserRepository {

    Boolean saveFollow(int id, int toFollow);

    User getById(int id);
}
