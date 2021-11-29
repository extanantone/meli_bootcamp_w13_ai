package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.exception.NotFoundUserException;
import com.bootcamp.socialmeli.exception.NotPossibleFollowUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
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
    public User createUser(String name){
        User user = new User(userList.size()+1, name);
        userList.add(user);
        return user;
    }

    @Override
    public User getUser(int userId) throws NotPossibleOperationException {
        for (User user : userList){
            if (user.getId() == userId){
                return user;
            }
        }
        throw new NotFoundUserException(userId);
    }

    @Override
    public void followUser(User user, User userToFollow) throws NotPossibleOperationException {
        if (user == null || userToFollow == null)   throw new NotFoundUserException();
        if (user.getId() == userToFollow.getId())   throw new NotPossibleFollowUserException();

        boolean isFollowed = user.getFollowedUserId().contains(userToFollow.getId());

        if (!isFollowed) {
            user.addFollowed(userToFollow.getId());
            userToFollow.addFollower(user.getId());
        }
    }

    @Override
    public int getTotalUserFollowers(User user) throws NotPossibleOperationException {
        if (user == null) throw new NotFoundUserException();
        return user.getFollowersUserId().size();
    }

    @Override
    public List<User> getUsersFollowers(int userId) throws NotPossibleOperationException{
        User user = getUser(userId);
        if (user == null) throw new NotFoundUserException(userId);
        List<User> userListFollowers = new ArrayList<>();

        for(int id : user.getFollowersUserId()){
            userListFollowers.add(getUser(id));
        }
        return userListFollowers;
    }

    @Override
    public List<User> getUsersFollowed(User user) throws NotPossibleOperationException{
        if (user == null) throw new NotFoundUserException();
        List<User> usersFollowed = new ArrayList<>();

        for (int id : user.getFollowedUserId()){
            usersFollowed.add(getUser(id));
        }
        return usersFollowed;
    }

    @Override
    public void unfollowUser(User user, User userToUnfollow) throws NotPossibleOperationException{
        if (user == null || userToUnfollow == null) throw new NotFoundUserException();
        if (user.getId() == userToUnfollow.getId())   throw new NotPossibleFollowUserException();

        boolean isFollowed = user.getFollowedUserId().contains(userToUnfollow.getId());

        if (isFollowed) {
            user.removeFollowed(userToUnfollow.getId());
            userToUnfollow.removeFollower(user.getId());
        }
    }

}
