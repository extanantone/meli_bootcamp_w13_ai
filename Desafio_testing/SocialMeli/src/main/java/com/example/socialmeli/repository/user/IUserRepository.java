package com.example.socialmeli.repository.user;

import com.example.socialmeli.model.User;

import java.util.List;
import java.util.Map;

public interface IUserRepository
{
    Map<Integer, User> usersMap();

    List<User> findFollowersOrderByNameDesc(int userId);

    List<User> findFollowersOrderByNameAsc(int userId);

    List<User> findFollowedOrderByNameDesc(int userId);

    List<User> findFollowedOrderByNameAsc(int userId);
}
