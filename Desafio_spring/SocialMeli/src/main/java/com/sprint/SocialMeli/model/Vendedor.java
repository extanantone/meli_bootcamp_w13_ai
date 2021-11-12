package com.sprint.SocialMeli.model;

import java.util.*;

public class Vendedor extends Usuario{
    List<Integer> followersIds;
    List<Integer> postsIds;

    public Vendedor(int user_id, String user_name) {
        super(user_id, user_name);
        followersIds = new ArrayList<>();
        postsIds = new ArrayList<>();
    }

    public void addFollower(int user_id){
        followersIds.add(user_id);
    }

    public Integer followersCount(){
        return followersIds.size();
    }

    public boolean existsFollower(int user_id){
        return followersIds.contains(user_id);
    }

    public List<Integer> getFollowersIds(){
        return followersIds;
    }

    public void addPost(int post_id){
        postsIds.add(post_id);
    }

    public boolean existsPost(int post_id){
        return postsIds.contains(post_id);
    }

    public List<Integer> getPostsIds(){
        return postsIds;
    }

    @Override
    TipoUsuario getUserType() {
        return TipoUsuario.VENDEDOR;
    }
}
