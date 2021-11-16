package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;

public interface IPostService {

    public PostDTO getPost(long id);
    public PostDTO createPost(PostDTO postDTO);
}
