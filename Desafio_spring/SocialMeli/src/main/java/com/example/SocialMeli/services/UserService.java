package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.UserCountFollowersDTO;
import com.example.SocialMeli.dto.UserFollowersDTO;

public interface UserService {

    Boolean saveFollow(int user_id, int toFollow) throws Exception;

    UserCountFollowersDTO countFollowers(int user_id) throws Exception;

    UserFollowersDTO listFollowers(int user_id, String order) throws Exception;

    UserFollowersDTO listFolloweds(int user_id, String order) throws Exception;

    Boolean unfollow(int user_id, int id_to_unfollow) throws Exception;

}
