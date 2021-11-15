package com.Sprint1.SocialMeli.repository;

import com.Sprint1.SocialMeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User>  findUser(int user_id);

}
