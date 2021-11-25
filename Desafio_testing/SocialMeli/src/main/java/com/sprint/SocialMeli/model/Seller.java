package com.sprint.SocialMeli.model;

import java.util.*;

public class Seller extends User {
    List<Integer> followersIds;
    List<Integer> postsIds;

    public Seller(int userId, String userName) {
        super(userId, userName);
        followersIds = new LinkedList<>();
        postsIds = new LinkedList<>();
    }

    public void addFollower(int userId){
        if(!followersIds.contains(userId))
            followersIds.add(userId);
    }

    public void deleteFollower(int userId){
        if(!followersIds.contains(userId))
            followersIds.remove(userId);
    }

    public Integer followersCount(){
        return followersIds.size();
    }

    public List<Integer> getFollowersIds(){
        return followersIds;
    }

    public void addPost(int postId){
        if(!postsIds.contains(postId))
            postsIds.add(postId);
    }

    public List<Integer> getPostsIds(){
        return postsIds;
    }

    @Override
    public UserType getUserType() {
        return UserType.SELLER;
    }
}
