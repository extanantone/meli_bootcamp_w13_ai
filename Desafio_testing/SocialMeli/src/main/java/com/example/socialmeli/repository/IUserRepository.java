package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;

import java.util.Map;
import java.util.Set;

public interface IUserRepository {
    Set<Map.Entry<Integer, User>> findAll();
    User find(Integer id);
}
