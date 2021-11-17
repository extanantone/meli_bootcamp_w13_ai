package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {

    public List<UserDTO> getAll();
    public UserDTO getUser(long id);
    public UserDTO createUser(UserCreationDTO user);
    public void deleteUser(long id);
    public void followUser(long followerId, long followedId);
    public UserWithCountDTO getFollowerCount(long id);
    public UserWithFollowersDTO getFollowers(long id);
    public UserWithCountDTO getFollowedCount(long id);
    public UserWithFollowedDTO getFollowed(long id);
    public void unfollowUser(long followerId, long followedId);
    public List<UserDTO> orderUsersByName(List<UserDTO> users, String order);
    public void checkUserExistence(long userId);
}
