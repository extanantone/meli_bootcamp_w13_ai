package com.example.socialmeli.service.user;

import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.dto.user.FollowerCountDTO;
import com.example.socialmeli.dto.user.FollowerListDTO;

public interface IUserService
{
    FollowerListDTO follow(int userId, int userIdToFollow);

    FollowerListDTO unfollow(int userId, int userIdToFollow);

    FollowerCountDTO countFollowers(int userId);

    FollowerListDTO followers(int userId, String order);

    FollowedListDTO followed(int userId, String order);
}
