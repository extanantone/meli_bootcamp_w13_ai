package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.UserWithPostsDTO;

import java.util.List;

public interface IPostService {

    public PostDTO getPost(long id);
    public PostDTO createPost(PostDTO postDTO);
    public UserWithPostsDTO getLatestFollowedPosts(long userId, int weeks);
    public List<PostDTO> orderPostsByDate(List<PostDTO> posts, String order);
}
