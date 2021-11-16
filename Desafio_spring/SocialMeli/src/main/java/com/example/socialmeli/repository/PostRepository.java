package com.example.socialmeli.repository;

import com.example.socialmeli.exception.UserIdNotFoundException;
import com.example.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository implements IPostRepository{
    Map<Integer, Post> posts = new HashMap<>();

    @Override
    public Post find(Integer id) {
        if (posts.containsKey(id)) {
            return posts.get(id);
        }
        throw new UserIdNotFoundException(id); // Placeholder
    }

    @Override
    public boolean addPost(Integer id, Post post) { return posts.putIfAbsent(id, post) != null; }

    public Map<Integer, Post> getPosts() {
        return posts;
    }
}
