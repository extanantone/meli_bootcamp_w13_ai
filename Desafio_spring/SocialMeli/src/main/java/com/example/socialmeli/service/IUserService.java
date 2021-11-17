package com.example.socialmeli.service;


import com.example.socialmeli.dto.FollowedDto;
import com.example.socialmeli.dto.FollowersDto;


public interface IUserService {
    public  void follower(Integer userId,Integer userIdToFollow);

    void unfollow(Integer userId, Integer userIdToUnfollow);

    public FollowersDto followersCount(Integer userId);
    public FollowersDto followers(Integer userId,String order);
    public FollowedDto followed(Integer userId,String order);
}
