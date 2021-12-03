package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.dto.UserFollowedDTO;
import com.bootcamp.SocialMeli.dto.UserCountFollowersDTO;
import com.bootcamp.SocialMeli.dto.UserFollowersDTO;

import java.util.List;

public interface UserService {
    UserCountFollowersDTO countFollowers (int userId);
    void followUser(int userId,int userIdToFollow);
    void unfollowUser(int userId,int userIdToFollow);
    UserDTO getUserById(int userId);
    List<UserDTO> allUsers();
    UserFollowersDTO getFollowersList(int userId);
    UserFollowersDTO orderByNameFollowers(int userId, String order);

    UserFollowedDTO getFollowedList(int userId);
    UserFollowedDTO orderByNameFollowed(int userId, String order);


}