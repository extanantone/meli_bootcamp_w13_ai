package com.socialmeli.repository;

import com.socialmeli.model.User;

public interface IUserRepository {
    User getUserById(int id);
}
