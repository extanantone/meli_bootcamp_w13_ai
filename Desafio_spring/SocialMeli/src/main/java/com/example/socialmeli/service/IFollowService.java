package com.example.socialmeli.service;

import com.example.socialmeli.dto.FollowerCountDTO;

public interface IFollowService {

    void addFollow(Integer userId, Integer followId);
    FollowerCountDTO followerCount(Integer userId);

}
