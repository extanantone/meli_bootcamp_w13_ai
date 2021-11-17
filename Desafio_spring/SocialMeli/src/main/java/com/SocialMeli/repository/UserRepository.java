package com.SocialMeli.repository;

import com.SocialMeli.model.Post;
import com.SocialMeli.model.PromoPost;
import com.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository implements UserRepositoryI {
    private final HashMap<Integer, User> usersList = new HashMap<>();
    private final HashMap<Integer, Post> postsList = new HashMap<>();
    private final HashMap<Integer, PromoPost> promoPostsList = new HashMap<>();

    UserRepository() {
        usersList.put(1, new User(1, "Juan123", false));
        usersList.put(2, new User(2, "pedro_8", false));
        usersList.put(3, new User(3, "lali_gon", true));
        usersList.put(4, new User(4, "ana-paula", true));
    }


    @Override
    public HashMap<Integer, User> getUsers() {
        return usersList;
    }

    @Override
    public HashMap<Integer, Post> getPosts() {
        return postsList;
    }

    @Override
    public HashMap<Integer, PromoPost> getPromoPosts() {
        return promoPostsList;
    }

    @Override
    public void addUser(User newUser) {
        usersList.put(newUser.getId(), newUser);
    }

    @Override
    public void addPost(Post newPost) {
        postsList.put(newPost.getIdPost(), newPost);
    }

    @Override
    public void addPromoPost(PromoPost newPromoPost) {
        promoPostsList.put(newPromoPost.getIdPost(), newPromoPost);
    }

}
