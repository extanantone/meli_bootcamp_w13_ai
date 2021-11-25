package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.FollowedListResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerCountResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerListResponseDTO;

public interface IUserService {
    boolean follow(Long followerID, Long followedID);
    boolean unfollow(Long followerID, Long followedID);
    FollowerCountResponseDTO followersCount(Long userID);
    FollowerListResponseDTO followersList(Long userID, String order);
    FollowedListResponseDTO followedList(Long userID, String order);
}
