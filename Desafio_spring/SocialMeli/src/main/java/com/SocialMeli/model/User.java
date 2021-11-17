package com.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    private int id;
    private String userName;
    private List<Integer> followers;
    private List<Integer> followedUsers;
    private boolean isSeller;
    private List<Integer> posts;
    private List<Integer> promoPosts;

    public User(int id, String userName, boolean isSeller) {
        this.id = id;
        this.userName = userName;
        this.isSeller = isSeller;
        this.followers = new ArrayList<>();
        this.followedUsers = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.promoPosts = new ArrayList<>();
    }

    public boolean getIsSeller() {
        return this.isSeller;
    }

    public void setIsSeller(boolean isSeller) {
        this.isSeller = isSeller;
    }

}
