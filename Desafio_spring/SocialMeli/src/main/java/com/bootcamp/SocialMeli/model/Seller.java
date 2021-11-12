package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Seller extends User{
    private Map<Integer, User> followers;

    public Seller(int id, String name) {
        super(id, name, new HashMap<Integer, Seller>());
        this.followers = new HashMap<Integer, User>();
    }

    public void addFollower(User user) {
        int userId = user.getId();
        if (this.followers.containsKey(userId)) throw new RuntimeException("follower already exists");
        //implementar excepciones y handler
        this.followers.put(userId, user);
    }

    public void removeFollower(int userId) {
        if (!this.followers.containsKey(userId)) throw new RuntimeException("follower doesn't exist");
        this.followers.remove(userId);
    }
}
