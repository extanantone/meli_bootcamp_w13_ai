package com.example.socialmeli.service.user;

import com.example.socialmeli.dto.FollowedListDTO;
import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;

public interface IUserService
{
    FollowerListDTO follow(int user_id, int user_id_to_follow);

    FollowerCountDTO countFollowers(int user_id);

    FollowerListDTO followers(int user_id);

    FollowedListDTO followed(int user_id);
}
