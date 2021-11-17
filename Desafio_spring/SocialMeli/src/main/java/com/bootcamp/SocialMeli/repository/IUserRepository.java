package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    public void followUser(Integer userId, Integer userIdToFollow);
    public List<User> getUsersList();
    public Optional<User> getUser(Integer userId);

}
