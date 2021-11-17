package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class User {
    private int userId;
    private String userName;
    private ArrayList<User> followers;
    private ArrayList<User> followed;
    private ArrayList<Post> posts;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }
}