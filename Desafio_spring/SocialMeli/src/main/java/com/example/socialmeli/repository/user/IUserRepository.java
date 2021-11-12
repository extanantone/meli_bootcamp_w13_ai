package com.example.socialmeli.repository.user;

import com.example.socialmeli.model.User;

import java.util.Map;

public interface IUserRepository
{
    Map<Integer, User> usersMap();
}
