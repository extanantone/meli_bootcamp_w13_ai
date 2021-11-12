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

    public boolean existsPost(int id_post){
        return posts.containsKey(id_post);
    }

    public User getUser(int user_id){
        return users.get(user_id);
    }

    public void putUser(User user){
        users.put(user.getUser_id(), user);
    }

    public void putPost(Post post){
        posts.put(post.getId_post(), post);
    }

    @Override
    public Post getPost(int id_post) {
        return posts.get(id_post);
    }


}
