package com.example.socialmeli.unit.utils;

import com.example.socialmeli.Models.User;

import java.util.Hashtable;

public class UtilsUserService {
    static User user1 = new User("Lina");
    static User user2 = new User("Carlos");
    static User user3 = new User("Francisco");
    static User user4 = new User("Juliana");
    Hashtable<Integer, User> tableUsers = new Hashtable<>();


    public static User getUser2(){
        Hashtable<Integer, User> tableUsersFolloweed = new Hashtable<>();
        Hashtable<Integer, User> tableUsersFollowers = new Hashtable<>();

        // set followers of 2
        tableUsersFollowers.put(user1.getUserId(), user1);
        tableUsersFollowers.put(user3.getUserId(), user3);
        user2.setFollowers(tableUsersFollowers);

        // set followees of 2
        tableUsersFolloweed.put(user1.getUserId(), user1);
        tableUsersFolloweed.put(user3.getUserId(), user3);
        user2.setFollowees(tableUsersFolloweed);
        return user2;
    }

    public static User getUser4(){
        return user4;
    }


}
