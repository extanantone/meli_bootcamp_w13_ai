package com.socialMeli.SocialMeli.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String username;
    private List<Integer> following = new ArrayList<>();
    private List<Integer> followers = new ArrayList<>();

    public User(Integer id, String username) {
        this.id=id;
        this.username=username;
    }

    public Integer getId() {
        return id;
    }




    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }
}
