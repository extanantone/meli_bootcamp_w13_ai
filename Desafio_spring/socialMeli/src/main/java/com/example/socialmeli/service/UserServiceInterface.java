package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostRequestResponseDto;
import com.example.socialmeli.dto.UserResponseDto;
import com.example.socialmeli.dto.UsersResponseDto;

public interface UserServiceInterface {

    PostRequestResponseDto followUser(Integer user_id, Integer user_id_to_follow);
    UserResponseDto getFollowersCount(Integer user_id);
    UserResponseDto getFollowersList(Integer user_id,String order);
    UserResponseDto getFollowedList(Integer user_id, String order);
    UsersResponseDto getUsers();
    PostRequestResponseDto unfollow(Integer user_id, Integer user_id_to_unfollow);
}
