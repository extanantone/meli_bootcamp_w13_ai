package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;
//import com.bootcamp.socialmeli.model.UserFollow;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private List<User> userList;


    public UserRepository(){
        userList = new ArrayList<>();
        userList.add(new User(1,"Nico"));
        userList.add(new User(2,"Juan"));
        userList.add(new User(3,"Pedro"));
        userList.add(new User(4,"Carlos"));
    }

    @Override
    public User getUser(int userId) {
        for (User user : userList){
            if (user.getId() == userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean followUser(int userId, int userFollowedId) {
        User user = getUser(userId);
        if (user != null) {
            User userFollowed = getUser(userFollowedId);
            user.addFollowed(userFollowedId);
            userFollowed.addFollower(userId);
            return true;
        }
        return false;
    }

    @Override
    public int getTotalUserFollowers(int userId) {
        User user = getUser(userId);
        return user.getFollowersUserId().size();

    }

    @Override
    public List<User> getUsersFollowers(int userId) {
        User user = getUser(userId);
        List<User> userListFollowers = new ArrayList<>();

        for(int id : user.getFollowersUserId()){
            userListFollowers.add(getUser(id));
        }
        return userListFollowers;
    }

    @Override
    public boolean unfollowUser(int userId, int userToUnfollowId) {
        User user = getUser(userId);
        if (user != null) {
            User userFollowed = getUser(userToUnfollowId);
            user.removeFollowed(userToUnfollowId);
            userFollowed.removeFollower(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUsersFollowed(int userId) {
        User user = getUser(userId);
        List<User> usersFollowed = new ArrayList<>();

        for (int id : user.getFollowedUserId()){
            usersFollowed.add(getUser(id));
        }
        return usersFollowed;
    }

}
