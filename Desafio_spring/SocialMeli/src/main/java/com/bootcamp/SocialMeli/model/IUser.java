package com.bootcamp.SocialMeli.model;

public interface IUser {
    void addPost(Post post);

    void addFollowed(User user);

    void removeFollowed(int userId);

    void addFollower(User user);

    void removeFollower(int userId);
}
