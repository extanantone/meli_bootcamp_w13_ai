package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    Optional<Post> find(int postId);
    List<Post> findAll();
    Post create();
}
