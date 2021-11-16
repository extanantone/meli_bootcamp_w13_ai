package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserPostDTO;

public interface IPostService {
    void addPost(Integer userId, Integer postId, PostDTO post);
    UserPostDTO getPosts(Integer userId, String order);
}
