package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;

import java.util.List;

public interface IProductRepository {
    public void createPost(Post post);
    public Boolean findById(Integer postId);
    public List<Post> listPosts(Integer userId);

    List<Post> promoPost(Integer userId);
}
