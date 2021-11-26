package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.*;

import java.util.List;

public interface IPostService {

    public PostDTO getPost(long id);
    public PostDTO createPost(PostDTO postDTO);
    public List<PostDTO> getLatestPosts(List<PostDTO> posts, int weeks);
    public UserWithPostsDTO getLatestFollowedPosts(long userId, int weeks);
    public List<PostDTO> orderPostsByDate(List<PostDTO> posts, String order);
    public PromoPostDTO getPromoPost(long id);
    public PromoPostDTO createPromoPost(PromoPostDTO promoPostDTO);
    public UserWithCountDTO getUserWithPromoPostCount(long id);
    public UserWithPromoPostsDTO getUserWithPromoPosts(long id);
}
