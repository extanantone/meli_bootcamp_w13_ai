package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.UserCreationDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.dto.UserWithFollowersDTO;
import com.bootcamp.socialmeli.dto.UserWithFollowedDTO;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {

    public List<UserDTO> getAll();
    public UserDTO getUser(long id);
    public UserDTO createUser(UserCreationDTO user);
    public boolean deleteUser(long id);
    public boolean followUser(long followerId, long followedId);
    public int getFollowerCount(long id);
    public UserWithFollowersDTO getFollowers(long id);
    public int getFollowedCount(long id);
    public UserWithFollowedDTO getFollowed(long id);
    public boolean unfollowUser(long followerId, long followedId);
    public List<UserDTO> orderUsersByName(List<UserDTO> users, String order);
}
