package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public void followUser(User user, User userToFollow) {
        if (user == null || userToFollow == null)   throw new RuntimeException();

        user.addFollowed(userToFollow.getId());
        userToFollow.addFollower(user.getId());
    }

    @Override
    public int getTotalUserFollowers(User user) {
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
    public List<User> getUsersFollowed(User user) {
        List<User> usersFollowed = new ArrayList<>();

        for (int id : user.getFollowedUserId()){
            usersFollowed.add(getUser(id));
        }
        return usersFollowed;
    }

    @Override
    public void unfollowUser(User user, User userToUnfollow) {
        user.removeFollowed(userToUnfollow.getId());
        userToUnfollow.removeFollower(user.getId());
    }

}
