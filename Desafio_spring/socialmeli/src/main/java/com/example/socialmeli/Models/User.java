package com.example.socialmeli.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static Integer NumberUser = 0;
    private Integer userId;
    private String username;
    Hashtable<Integer, User> followers  = new Hashtable();
    Hashtable<Integer, User> followees  = new Hashtable();

    public User(String username) {
        this.username = username;
        NumberUser++;
        this.setUserId(NumberUser);
    }

    public User(Integer userId, String username) {
        this.username = username;
        this.userId = userId;
    }


    public Integer addFollowerList(User u){
        if ( !(followers.containsKey(u.getUserId()))){
            followers.put(u.getUserId(), u);
            return 1;
        }
        return null;
    }

    public Integer deleteFollowerList(User u){
        if ( followers.containsKey(u.getUserId())){
            followers.remove(u.getUserId());
            return 1;
        }
        return null;
    }



    public Integer addFolloweesList(User u){
        if ( !(followees.containsKey(u.getUserId()))){
            followees.put(u.getUserId(), u);
            return 1;
        }
        return null;
    }

    public Integer deleteFolloweesList(User u){
        if ( followees.containsKey(u.getUserId())){
            followees.remove(u.getUserId());
            return 1;
        }
        return null;
    }


    @JsonIgnore
    public Hashtable<Integer, User> getFollowers() {
        return followers;
    }





    public ArrayList getListFollowers(){
        Collection<User> values = followers.values();
        ArrayList<User> listOfValues = new ArrayList<>(values);
        return listOfValues;
    }

    public ArrayList getListFollowed(){
        Collection<User> values = followees.values();
        ArrayList<User> listOfValues = new ArrayList<>(values);
        return listOfValues;
    }

    public ArrayList<Integer> getArrayFolloweds(){
        Collection<User> values = followees.values();
        ArrayList<Integer> ArrayFollowes = new ArrayList();
        for (User x : values){
            ArrayFollowes.add(x.getUserId());
        }

        return ArrayFollowes;
    }

    public Integer getAmountFollowers(){
        return followers.size();
    }
}
