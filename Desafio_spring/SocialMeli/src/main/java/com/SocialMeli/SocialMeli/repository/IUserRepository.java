package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.dto.UserDTO;

public interface IUserRepository {
    UserDTO save(UserDTO user);
    UserDTO findUserByUserId(Integer user_id);
    Boolean follow(Integer user_id, Integer user_id_to_follow);
}
