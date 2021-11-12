package com.sprint.SocialMeli.model;

import java.util.*;

public class Seller extends User {
    List<Integer> followersIds;
    List<Integer> postsIds;

    public Seller(int user_id, String user_name) {
        super(user_id, user_name);
        followersIds = new LinkedList<>();
        postsIds = new LinkedList<>();
    }

    public void addFollower(int user_id){
        if(!followersIds.contains(user_id))
            followersIds.add(user_id);
    }

    public void deleteFollower(int user_id){
        if(!followersIds.contains(user_id))
            followersIds.remove(user_id);
    }

    public Integer followersCount(){
        return followersIds.size();
    }

    public List<Integer> getFollowersIds(){
        return followersIds;
    }

    public void addPost(int post_id){
        if(!postsIds.contains(post_id))
            postsIds.add(post_id);
    }

    public List<Integer> getPostsIds(){
        return postsIds;
    }

    @Override
    public UserType getUserType() {
        return UserType.SELLER;
    }
}
