package com.bootcamp.SocialMeli.model;

import com.bootcamp.SocialMeli.exception.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class User implements IUser{
    private int id;
    private String name;
    private Map<Integer, User> followed;
    private Map<Integer, User> followers;
    private Map<Integer, Post> posts;
    private boolean isSeller;

    public User(int id, String name, boolean isSeller) {
        this.id = id;
        this.name = name;
        this.followed = new HashMap<>();
        this.followers = new HashMap<>();
        this.posts = new HashMap<>();
        this.isSeller = isSeller;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.followed = new HashMap<>();
        this.followers = new HashMap<>();
        this.posts = new HashMap<>();
        this.isSeller = false;
    }


    public void addPost(Post post){
        int postId = post.getId();
        if (this.posts.containsKey(postId)) throw new PostAlreadyExistsException(postId);
        if (!this.isSeller) throw new ActionNotAllowedException("non-seller is not allowed to post products");
        this.posts.put(postId, post);
    }

    public void addFollowed(User user) {
        int userId = user.getId();
        if (this.followed.containsKey(userId)) throw new UserIsAlreadyFollowingException(this.id, userId);
        if (userId == this.id) throw new UserCannotFollowThemselfException(userId);
        if (!user.isSeller()) throw new ActionNotAllowedException("non-seller is not allowed to have followers");
        this.followed.put(userId, user);
    }

    public void removeFollowed(int userId) {
        if (!this.followed.containsKey(userId)) throw new UserIsNotFollowingException(this.id, userId);
        this.followed.remove(userId);
    }

    public void addFollower(User user) {
        int userId = user.getId();
        if (this.followers.containsKey(userId)) throw new UserIsAlreadyFollowingException(userId, this.id);
        if (userId == this.id) throw new UserCannotFollowThemselfException(userId);
        if (!this.isSeller) throw new ActionNotAllowedException("non-seller is not allowed to have followers");
        this.followers.put(userId, user);
    }

    public void removeFollower(int userId) {
        if (!this.followers.containsKey(userId)) throw new UserIsNotFollowingException(userId, this.id);
        this.followers.remove(userId);
    }
}
