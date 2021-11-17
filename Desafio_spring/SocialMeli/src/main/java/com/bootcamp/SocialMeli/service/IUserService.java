package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.*;

public interface IUserService {
    public void followUser(Integer userId, Integer userIdToFollow);
    public void unfollowUser(Integer userId, Integer userIdToUnfollow);
    public FollowerCountDTO countFollowers(Integer userId);
    public FollowersDTO getFollowers(Integer userId, String order);
    public FollowedDTO getFollowed(Integer userId, String order);
    public void newPublication(PostDTO dto);
}
