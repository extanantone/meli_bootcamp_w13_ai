package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.PostRequestResponseDto;
import com.example.socialmeli.dto.PostResponseDto;
import com.example.socialmeli.dto.UserResponseDto;

public interface PostServiceInterface {
    PostRequestResponseDto addPost(PostDto postReq);
    PostResponseDto getPostFromUserId(Integer user_id, String order);
    UserResponseDto countPostFromUserId(Integer user_id);
    PostResponseDto getPromoPostFromUserId(Integer user_id, String order);
}
