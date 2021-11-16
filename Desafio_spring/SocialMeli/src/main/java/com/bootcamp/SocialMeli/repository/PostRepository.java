package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository{
    Map<Integer, User> posts = new HashMap<>();

    @Override
    public Optional<Post> find(int postId) {
        return Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post create() {
        Post post = new Post();
        //setear todo?
        //this.products.put(postId, product);
        return post;
    }
}
