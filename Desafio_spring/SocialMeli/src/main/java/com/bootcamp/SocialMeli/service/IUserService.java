package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;


public interface IUserService {
    void follow(int followerId, int followedId);
    void unfollow(int followerId, int followedId);
    FollowersListDTO getFollowers(int userId);
    FollowedListDTO getFollowed(int userId);
    FollowersCountDTO getFollowersCount(int userId);
}
