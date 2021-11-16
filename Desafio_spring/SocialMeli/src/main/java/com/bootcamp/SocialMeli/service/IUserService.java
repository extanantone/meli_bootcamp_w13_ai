package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;

import java.util.Optional;


public interface IUserService {
    void create(int userId, String userName, boolean canSell);
    void follow(int followerId, int followedId);
    void unfollow(int followerId, int followedId);
    FollowersListDTO getFollowers(int userId, Optional<String> order);
    FollowedListDTO getFollowed(int userId, Optional<String> order);
    FollowersCountDTO getFollowersCount(int userId);
}
