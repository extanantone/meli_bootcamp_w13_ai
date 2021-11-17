package com.example.socialmeli.server;


import com.example.socialmeli.dto.FollowedDto;
import com.example.socialmeli.dto.FollowersDto;


public interface IUserServer {
    public  void follower(Integer userId,Integer userIdToFollow);

    void unfollow(Integer userId, Integer userIdToUnfollow);

    public FollowersDto followersCount(Integer userId);
    public FollowersDto followers(Integer userId,String order);
    public FollowedDto followed(Integer userId,String order);
}
