package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Post;

import java.util.List;

public interface IProductRepository {

    void postProduct(Post post);

    List<Post> getPost(int userId);
}
