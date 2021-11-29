package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
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

    public void addFollower(User user) {
        this.followers.put(user.userId, user);
    }

    public void addFollowed(User user) {
        this.followed.put(user.userId, user);
    }

    public void deleteFollower(User user) {
        this.followers.remove(user.userId);
    }

    public void deleteFollowed(User user) {
        this.followed.remove(user.userId);
    }

}
