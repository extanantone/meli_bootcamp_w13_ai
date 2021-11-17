package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.HashMap;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    private Integer userId;
    private String userName;
    private Map<Integer, User> followers = new HashMap<>();
    private Map<Integer, User> followed = new HashMap<>();

    public User() {
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public void addFollower(User user){
        this.followers.put(user.userId, user);
    }

    public void addFollowed(User user){
        this.followed.put(user.userId, user);
    }

    public void deleteFollower(User user){
        this.followers.remove(user.userId);
    }

    public void deleteFollowed(User user){
        this.followed.remove(user.userId);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<Integer, User> getFollowers() {
        return followers;
    }

    public void setFollowers(Map<Integer, User> followers) {
        this.followers = followers;
    }

    public Map<Integer, User> getFollowed() {
        return followed;
    }

    public void setFollowed(Map<Integer, User> followed) {
        this.followed = followed;
    }
}
