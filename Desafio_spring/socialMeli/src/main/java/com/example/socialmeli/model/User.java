package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class User {

    private static Integer userIdCount = 1;

    private Integer userId;
    private  String userName;
    private List<Integer> userFollowers; //seguidores
    private  List<Integer> userFollowed; //seguidos

    public User(String user_name) {
        this.userName = user_name;
        this.userFollowers = new ArrayList<Integer>();
        this.userFollowed = new ArrayList<Integer>();
        this.userId = this.userIdCount;
        this.userIdCount++;
    }

    public void setUserFollower(Integer user_follower_id) {
        this.userFollowers.add(user_follower_id);
    }

    public void setUserFollowed(Integer user_followed_id) {
        this.userFollowed.add(user_followed_id);
    }

    public boolean checkUserFollower(Integer user_id){
        return this.userFollowers.contains(user_id);
    }

    public boolean checkUserFollowed(Integer user_id){
        return this.userFollowed.contains(user_id);
    }

    public Integer getFollowersCount(){
        return this.userFollowers.size();
    }

    public List<Integer> getFollowersList(){
        return this.userFollowers;
    }

    public List<Integer> getFollowedList(){
        return this.userFollowed;
    }

    public void unFollow(Integer follow_user_id){
        this.userFollowed.remove(follow_user_id);
    }
    public void unFollowed(Integer followed_user_id){
        this.userFollowers.remove(followed_user_id);
    }

}
