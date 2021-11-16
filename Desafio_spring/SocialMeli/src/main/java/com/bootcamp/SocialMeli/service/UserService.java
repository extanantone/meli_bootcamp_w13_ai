package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public void create(int userId, String userName, boolean canSell) {
        userRepository.create(userId, userName, canSell);
    }

    @Override
    public void follow(int followerId, int followedId) {
        User follower = this.userRepository.find(followerId).orElseThrow();
        //tirar excepción si no es vendedor
        User followed = this.userRepository.find(followedId).orElseThrow();

        follower.addFollowed(followed);
        followed.addFollower(follower);
    }

    @Override
    public void unfollow(int followerId, int followedId) {
        User follower = this.userRepository.find(followerId).orElseThrow();
        User followed = this.userRepository.find(followedId).orElseThrow();

        follower.removeFollowed(followedId);
        followed.removeFollower(followerId);

    }

    @Override
    public FollowersListDTO getFollowers(int userId) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowers = new ArrayList<>(user.getFollowers().values());
        return new FollowersListDTO(userId, user.getName(), listOfFollowers);
    }

    @Override
    public FollowedListDTO getFollowed(int userId) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowed = new ArrayList<>(user.getFollowed().values());
        return new FollowedListDTO(userId, user.getName(), listOfFollowed);
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowers = new ArrayList<>(user.getFollowers().values());
        return new FollowersCountDTO(userId, user.getName(), listOfFollowers);
    }
}
