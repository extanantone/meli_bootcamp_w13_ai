package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.exception.PostAlreadyExistsException;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository{
    Map<Integer, Post> posts = new HashMap<>();

    @Override
    public Optional<Post> find(int postId) {
        return Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public void add(Post post) {
        int postId = post.getId();
        if (this.posts.containsKey(postId)) throw new PostAlreadyExistsException(postId);
        this.posts.put(postId, post);
        return;
    }
}
