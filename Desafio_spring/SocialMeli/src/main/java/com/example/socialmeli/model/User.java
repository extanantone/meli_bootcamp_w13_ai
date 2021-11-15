package com.example.socialmeli.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final Integer id;
    private final String name;
    private final Set<Integer> followers;
    private final Set<Integer> followed;

    public boolean addFollower(Integer id) { return followers.add(id); }

    public boolean addFollow(Integer id) { return followed.add(id); }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.followers = new HashSet<>();
        this.followed = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public Set<Integer> getFollowers() { return followers; }

    public Set<Integer> getFollowed() { return followed; }

    public String getName() { return name; }
}
