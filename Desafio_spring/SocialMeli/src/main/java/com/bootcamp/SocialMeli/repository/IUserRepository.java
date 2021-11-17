package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserRepository {
//    public void followUser(Integer userId, Integer userIdToFollow);

    public List<User> getUsersList();

    public Optional<User> getUser(Integer userId);

    public void addPost(Post p);

    public Map<Integer, Post> getPosts();

}
