package com.bootcamp.SocialMeli.repository;


import com.bootcamp.SocialMeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> find(int userId);
    List<User> findAll();
    User add(int userId, String userName, boolean isSeller);
}
