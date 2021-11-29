package com.socialmeli.demo.service;

import com.socialmeli.demo.dto.PostDTO;
import com.socialmeli.demo.dto.UserWithFollowedPostsListDTO;

public interface IPostService {

    public PostDTO addPost(PostDTO postDTO);
    public UserWithFollowedPostsListDTO getUserWithFollowedPosts(Integer id, String order);

}
