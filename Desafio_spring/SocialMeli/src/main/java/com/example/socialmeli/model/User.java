package com.example.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User
{
    private static int globUserId = 1;
    private int userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;

    public User()
    {
        this.userId = globUserId++;
        this.followers = new LinkedList<>();
        this.followed = new LinkedList<>();
    }
    public User(String userName)
    {
        this.userId = globUserId++;
        this.userName = userName;
        this.followers = new LinkedList<>();
        this.followed = new LinkedList<>();
    }

    private boolean alreadyFollowing(User user)
    {
        return this.followers.contains(user);
    }

    public boolean follow(User user)
    {
        if (user == null || alreadyFollowing(user) || (this.getUserId() == user.getUserId()))
            return false;

        this.followers.add(user);
        user.followed.add(this);
        return true;
    }

    public boolean unfollow(User user)
    {
        if (user == null || alreadyFollowing(user) || this.getUserId() == user.getUserId())
            return false;

        this.followers.remove(user);
        user.followed.remove(this);
        return true;
    }

}
