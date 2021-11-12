package com.sprint.SocialMeli.repository;

import com.sprint.SocialMeli.model.Post;
import com.sprint.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SocialRepository implements ISocialRepository{
    Map<Integer, User> users;
    Map<Integer, Post> posts;

    public SocialRepository(){
        users = new HashMap<>();
        posts = new HashMap<>();
    }

    public boolean existsUser(int user_id){
        return users.containsKey(user_id);
    }

    public boolean existsPost(int post_id){
        return posts.containsKey(post_id);
    }

    public User getUser(int user_id){
        return users.get(user_id);
    }

    public void putUser(User user){
        users.put(user.getUser_id(), user);
    }

    public void putPost(User user){
        users.put(user.getUser_id(), user);
    }


}
