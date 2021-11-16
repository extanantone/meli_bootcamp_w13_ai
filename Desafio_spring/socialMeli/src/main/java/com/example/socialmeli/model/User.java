package com.example.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class User {

    private static Integer user_id_count = 1;

    private Integer user_id;
    private  String userName;
    private List<Integer> user_followers; //seguidores
    private  List<Integer> user_followed; //seguidos

    public User(String user_name) {
        this.userName = user_name;
        this.user_followers = new ArrayList<Integer>();
        this.user_followed  = new ArrayList<Integer>();
        this.user_id = this.user_id_count;
        this.user_id_count++;
    }

    public void setUserFollower(Integer user_follower_id) {
        this.user_followers.add(user_follower_id);
    }

    public void setUserFollowed(Integer user_followed_id) {
        this.user_followed.add(user_followed_id);
    }

    public boolean checkUserFollower(Integer user_id){
        return this.user_followers.contains(user_id);
    }

    public boolean checkUserFollowed(Integer user_id){
        return this.user_followed.contains(user_id);
    }

    public Integer getFollowersCount(){
        return this.user_followers.size();
    }

    public List<Integer> getFollowersList(){
        return this.user_followers;
    }

    public List<Integer> getFollowedList(){
        return this.user_followed;
    }

    public void unFollow(Integer follow_user_id){
        this.user_followed.remove(follow_user_id);
    }
    public void unFollowed(Integer followed_user_id){
        this.user_followers.remove(followed_user_id);
    }

}
