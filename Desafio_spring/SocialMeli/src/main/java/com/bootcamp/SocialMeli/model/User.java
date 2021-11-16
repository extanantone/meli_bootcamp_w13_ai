package com.bootcamp.SocialMeli.model;

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
    private boolean canSell;

    public User(int id, String name, boolean canSell) {
        this.id = id;
        this.name = name;
        this.followed = new HashMap<Integer, User>();
        this.followers = new HashMap<Integer, User>();
        this.posts = new HashMap<Integer, Post>();
        this.canSell = canSell;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.followed = new HashMap<Integer, User>();
        this.followers = new HashMap<Integer, User>();
        this.posts = new HashMap<Integer, Post>();
        this.canSell = false;
    }


    public void addPost(Post post){
        int postId = post.getId();
        if (this.posts.containsKey(postId)) throw new RuntimeException("post already exists");
        //implementar excepciones y handler
        this.posts.put(postId, post);
    }

    public void addFollowed(User user) {
        int userId = user.getId();
        if (this.followed.containsKey(userId)) throw new RuntimeException("followed already exists");
        //implementar excepciones y handler
        this.followed.put(userId, user);
    }

    public void removeFollowed(int userId) {
        if (!this.followed.containsKey(userId)) throw new RuntimeException("followed doesn't exist");
        //implementar excepciones y handler
        this.followed.remove(userId);
    }

    public void addFollower(User user) {
        int userId = user.getId();
        if (this.followers.containsKey(userId)) throw new RuntimeException("follower already exists");
        //implementar excepciones y handler
        this.followers.put(userId, user);
    }

    public void removeFollower(int userId) {
        if (!this.followers.containsKey(userId)) throw new RuntimeException("follower doesn't exist");
        //implementar excepciones y handler
        this.followers.remove(userId);
    }
}
