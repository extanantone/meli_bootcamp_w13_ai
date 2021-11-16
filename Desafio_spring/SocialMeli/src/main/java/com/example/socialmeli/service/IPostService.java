package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDTO;

public interface IPostService {
    void addPost(Integer userId, Integer postId, PostDTO post);
}
