package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.User;

import java.util.Optional;

public interface ISocialMeliRepository {
    Optional<User> findUser(int userId);
}