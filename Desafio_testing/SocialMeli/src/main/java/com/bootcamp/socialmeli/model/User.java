package com.bootcamp.socialmeli.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Data
public class User {
    private int id;
    private String name;
    private List<Integer> followedUserId;
    private List<Integer> followersUserId;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.followedUserId = new ArrayList<>();
        this.followersUserId = new ArrayList<>();
    }

    public void addFollowed(int id){
        followedUserId.add(id);
    }

    public void addFollower(int id){
        followersUserId.add(id);
    }

    public void removeFollowed(int id){
        followedUserId = followedUserId.stream()
                .filter(u -> u != id)
                .collect(Collectors.toList());
    }

    public void removeAllFollowed(){
        followedUserId = new ArrayList<>();
    }

    public void removeFollower(int id){
        followersUserId = followersUserId.stream()
                .filter(u -> u != id)
                .collect(Collectors.toList());
    }

    public void removeAllFollower(){
        followersUserId = new ArrayList<>();
    }

}
