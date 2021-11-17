package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.model.Post;

import java.util.Optional;

public interface IPostService {
    void addPost(Post post);
    FollowedPostsDTO getFollowedPosts(int userId, Optional<String> order);
}
