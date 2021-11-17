package com.example.socialmeli.repository;

import com.example.socialmeli.exception.PostIdNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PromoPost;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository implements IPostRepository{
    Map<Integer, Post> posts = new HashMap<>();
    Map<Integer, PromoPost> promoPosts = new HashMap<>();

    @Override
    public Post find(Integer id) {
        if (posts.containsKey(id)) {
            return posts.get(id);
        }
        throw new PostIdNotFoundException(id);
    }

    @Override
    public boolean addPost(Integer id, Post post) {
        if (!promoPosts.containsKey(id)) { return posts.putIfAbsent(id, post) == null; }
        return false;
    }

    @Override
    public boolean addPromoPost(Integer id, PromoPost promoPost) {
        if (!posts.containsKey(id)) { return promoPosts.putIfAbsent(id, promoPost) == null; }
        return false;
    }

    @Override
    public Map<Integer, Post> getPosts() {
        return posts;
    }

    @Override
    public Map<Integer, PromoPost> getPromoPosts() { return promoPosts; }
}
