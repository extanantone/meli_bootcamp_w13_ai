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
    private List<User> followed;
    private List<User> followers;
    private List<Post> posts;

    public User()
    {
        this.userId = globUserId++;
        this.followed = new LinkedList<>();
        this.followers = new LinkedList<>();
        this.posts = new LinkedList<>();
    }

    public User(String userName)
    {
        this.userId = globUserId++;
        this.userName = userName;
        this.followed = new LinkedList<>();
        this.followers = new LinkedList<>();
        this.posts = new LinkedList<>();
    }

    private boolean alreadyFollowing(User user)
    {
        return this.followed.contains(user);
    }

    public boolean follow(User user)
    {
        if (user == null || alreadyFollowing(user) || (this.getUserId() == user.getUserId()))
            return false;

        this.followed.add(user);
        user.followers.add(this);
        return true;
    }

    public boolean unfollow(User user)
    {
        if (user == null || !alreadyFollowing(user) || this.getUserId() == user.getUserId())
            return false;

        this.followed.remove(user);
        user.followers.remove(this);
        return true;
    }

    public boolean addPost(Post post)
    {
        if (post.getUserId() != this.userId)
            return false;

        this.posts.add(post);
        return true;
    }

    public static void resetId()
    {
        globUserId = 1;
    }
}
