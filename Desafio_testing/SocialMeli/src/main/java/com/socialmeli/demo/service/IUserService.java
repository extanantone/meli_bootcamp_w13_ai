package com.socialmeli.demo.service;

import com.socialmeli.demo.dto.*;

import java.util.List;

public interface IUserService {

    public UserDTO addUser(AddUserDTO addUserDTO);
    public UserDTO getUserById(Integer id);
    public List<UserDTO> getUsers();
    public UserFollowedDTO followUser(Integer userId, Integer userToFollowId);
    public UserFollowersDTO getUserFollowersList(Integer userId, String order);
    public UserFollowedDTO getUserFollowedList(Integer userId, String order);
    public UserWithFollowersCountDTO getUserFollowersCount(Integer userId);
    public void unfollowUser(Integer userId, Integer userIdToUnfollow);
}
