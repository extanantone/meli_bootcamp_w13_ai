package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post getPost(Long postId);
    Long savePost(Post newPost, Long userID);
    List<Post> getAllPosts();
    List<Post> getUserPosts(Long userID);
}
