package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;

import java.util.Map;


public interface IPostRepository {
    Post find(Integer id);
    boolean addPost(Integer id, Post post);
    Map<Integer, Post> getPosts();
}
