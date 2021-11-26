package com.example.socialmeli.service;

import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;

public interface IFollowService {

    void addFollow(Integer userId, Integer followId);
    void removeFollow(Integer userId, Integer followId);
    FollowerListDTO sortedFollowerList(Integer userId, String order);
    FollowerListDTO sortedFollowingList(Integer userId, String order);
    FollowerCountDTO followerCount(Integer userId);
    FollowerListDTO followerList(Integer userId);
    FollowerListDTO followingList(Integer userId);

}
