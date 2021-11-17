package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsCountDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsDTO;
import com.bootcamp.SocialMeli.model.Post;

import java.util.Optional;

public interface IPostService {
    void addPost(Post post);
    FollowedPostsDTO getFollowedPosts(int userId, Optional<String> order);
    PromoPostsCountDTO getPromoPostsCount(int userId, Optional<String> order);
    PromoPostsDTO getPromoPosts(int userId, Optional<String> order);
}
