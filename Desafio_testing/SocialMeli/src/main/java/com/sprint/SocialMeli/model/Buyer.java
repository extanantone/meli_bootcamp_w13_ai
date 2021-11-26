package com.sprint.SocialMeli.model;

import lombok.val;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Buyer extends User {
    List<Integer> followedIds;

    public Buyer(int userId, String user_name) {
        super(userId, user_name);
        followedIds = new LinkedList<>();
    }

    public void addFollowed(Integer userId){
        if(!followedIds.contains(userId))
            followedIds.add(userId);
    }

    public void deleteFollowed(Integer userId){
        followedIds.remove(userId);
    }

    public Integer followedCount() {
        return followedIds.size();
    }

    public List<Integer> getFollowedIds(){
        return followedIds;
    }

    @Override
    public UserType getUserType() {
        return UserType.BUYER;
    }
}
