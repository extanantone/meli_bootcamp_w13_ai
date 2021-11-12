package com.sprint.SocialMeli.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    List<Integer> followedIds;

    public Buyer(int user_id, String user_name) {
        super(user_id, user_name);
        followedIds = new ArrayList<>();
    }

    public void addFollowed(int user_id){
        if(!followedIds.contains(user_id))
            followedIds.add(user_id);
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
