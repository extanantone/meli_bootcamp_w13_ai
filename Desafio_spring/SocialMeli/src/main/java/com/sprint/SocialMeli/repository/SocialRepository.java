package com.sprint.SocialMeli.repository;

import com.sprint.SocialMeli.model.Post;
import com.sprint.SocialMeli.model.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialRepository {
    Map<Integer, Usuario> users;
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

    public Usuario getUser(int user_id){
        return users.get(user_id);
    }

    public void putUser(Usuario usuario){
        users.put(usuario.getUser_id(), usuario);
    }

    public void putPost(Usuario usuario){
        users.put(usuario.getUser_id(), usuario);
    }


}
