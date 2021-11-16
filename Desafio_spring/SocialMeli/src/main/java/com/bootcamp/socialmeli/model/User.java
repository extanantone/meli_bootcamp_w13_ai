package com.bootcamp.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String username;
    private String email;
    private String password;
    private List<User> followers;
    private List<User> following;
    private List<Post> posts;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.followers = new LinkedList<>();
        this.following = new LinkedList<>();
        this.posts = new LinkedList<>();
    }

}
