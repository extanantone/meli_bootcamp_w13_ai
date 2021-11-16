package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.model.Post;

public interface IPostService {
    void addPost(Post post);
    FollowedPostsDTO getFollowedPosts(int userId);
}
