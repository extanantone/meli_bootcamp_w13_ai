package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.UserFollowersDTO;

public interface UserService {

    Boolean saveFollow(int user_id, int toFollow) throws Exception;

    UserFollowersDTO countFollowers(int user_id) throws Exception;
}
