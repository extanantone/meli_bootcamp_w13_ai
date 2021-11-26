package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PromoPost;

import java.util.Map;


public interface IPostRepository {
    Post find(Integer id);
    boolean addPost(Integer id, Post post);
    Map<Integer, Post> getPosts();
    Map<Integer, PromoPost> getPromoPosts();
    boolean addPromoPost(Integer id, PromoPost promoPost);
}
