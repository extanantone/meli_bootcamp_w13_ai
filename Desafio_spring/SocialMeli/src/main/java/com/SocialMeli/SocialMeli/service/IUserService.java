package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.UserDTO;

public interface IUserService {
    UserDTO create(UserDTO user);
    Boolean followUser(Integer user_id, Integer user_id_to_follow);
}
