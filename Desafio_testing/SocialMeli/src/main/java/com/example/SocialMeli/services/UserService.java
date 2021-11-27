package com.example.SocialMeli.services;

import com.example.SocialMeli.dto.UserCountFollowersDTO;
import com.example.SocialMeli.dto.UserFollowersDTO;
import com.example.SocialMeli.exception.UserNotFoundException;

import java.io.IOException;

public interface UserService {

    Boolean saveFollow(int user_id, int toFollow) throws UserNotFoundException;

    UserCountFollowersDTO countFollowers(int user_id) throws UserNotFoundException;

    UserFollowersDTO listFollowers(int user_id, String order) throws UserNotFoundException;

    UserFollowersDTO listFolloweds(int user_id, String order) throws UserNotFoundException;

    Boolean unfollow(int user_id, int id_to_unfollow) throws UserNotFoundException;

}
