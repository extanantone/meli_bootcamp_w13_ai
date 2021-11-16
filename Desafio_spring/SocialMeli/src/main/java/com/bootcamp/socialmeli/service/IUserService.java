package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.UserFollowedDTO;
import com.bootcamp.socialmeli.dto.UserFollowersDTO;
import com.bootcamp.socialmeli.dto.UserListDTO;
import com.bootcamp.socialmeli.dto.UserTotalFollowersDTO;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {
    //US 0001
    void followUser(int userId, int userToFollowId);
    //US 0002
    UserTotalFollowersDTO getTotalUserFollowers(int id);
    //US 0003
    UserFollowersDTO getUsersFollowers(int id);
    //US 0004
    UserFollowedDTO getUsersFollowed(int id);
    //US 0007
    void unfollowUser(int userId, int userToUnfollowId);
    //US 0008
    UserFollowersDTO getUsersFollowers(int id, String order);
    UserFollowedDTO getUsersFollowed(int id, String order);
}
