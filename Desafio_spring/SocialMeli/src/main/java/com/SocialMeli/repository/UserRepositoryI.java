package com.SocialMeli.repository;

import com.SocialMeli.model.Post;
import com.SocialMeli.model.PromoPost;
import com.SocialMeli.model.User;

import java.util.HashMap;

public interface UserRepositoryI {
    HashMap<Integer, User> getUsers();
    HashMap<Integer, Post> getPosts();
    HashMap<Integer, PromoPost> getPromoPosts();

    void addUser(User newUser);
    void addPost(Post newPost);
    void addPromoPost(PromoPost newPromoPost);
}
