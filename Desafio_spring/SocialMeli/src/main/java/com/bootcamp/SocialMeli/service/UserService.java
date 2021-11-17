package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.exception.UserNotFoundException;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public void add(int userId, String userName, boolean isSeller) {
        userRepository.add(userId, userName, isSeller);
    }

    @Override
    public void follow(int followerId, int followedId) {

        User follower = this.userRepository.find(followerId).orElseThrow(() ->
                new UserNotFoundException(followerId));

        User followed = this.userRepository.find(followedId).orElseThrow(() ->
                new UserNotFoundException(followedId));

        follower.addFollowed(followed);
        followed.addFollower(follower);
    }

    @Override
    public void unfollow(int followerId, int followedId) {
        User follower = this.userRepository.find(followerId).orElseThrow(() ->
                new UserNotFoundException(followerId));

        User followed = this.userRepository.find(followedId).orElseThrow(() ->
                new UserNotFoundException(followedId));

        follower.removeFollowed(followedId);
        followed.removeFollower(followerId);

    }

    @Override
    public FollowersListDTO getFollowers(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));

        List<User> listOfFollowers = new ArrayList<>(user.getFollowers().values());
        if (order.isPresent()) {
            if (order.get().equals("name_asc")) {
                listOfFollowers.sort(Comparator.comparing(User::getName));
            }
            else if (order.get().equals("name_desc")) {
                listOfFollowers.sort(Comparator.comparing(User::getName).reversed());
            }
        }
        return new FollowersListDTO(userId, user.getName(), listOfFollowers);
    }

    @Override
    public FollowedListDTO getFollowed(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));

        List<User> listOfFollowed = new ArrayList<>(user.getFollowed().values());

        if (order.isPresent()) {
            if (order.get().equals("name_asc")) {
                listOfFollowed.sort(Comparator.comparing(User::getName));
            }
            else if (order.get().equals("name_desc")) {
                listOfFollowed.sort(Comparator.comparing(User::getName).reversed());
            }
        }
        return new FollowedListDTO(userId, user.getName(), listOfFollowed);

    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        User user = this.userRepository.find(userId).orElseThrow(() ->
                new UserNotFoundException(userId));

        List<User> listOfFollowers = new ArrayList<>(user.getFollowers().values());
        return new FollowersCountDTO(userId, user.getName(), listOfFollowers);
    }
}
