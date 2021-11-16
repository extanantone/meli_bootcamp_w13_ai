package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
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
    public void create(int userId, String userName, boolean canSell) {
        userRepository.create(userId, userName, canSell);
    }

    @Override
    public void follow(int followerId, int followedId) {
        User follower = this.userRepository.find(followerId).orElseThrow();
        //tirar excepción si no es vendedor o si son el mismo id
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
    public FollowersListDTO getFollowers(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowers = new ArrayList<>(user.getFollowers().values());
        if (order.isEmpty()) return new FollowersListDTO(userId, user.getName(), listOfFollowers);
        if (order.get().equals("name_asc")) {
            listOfFollowers.sort(Comparator.comparing(User::getName));
        }
        else if (order.get().equals("name_desc")) {
            listOfFollowers.sort(Comparator.comparing(User::getName).reversed());
        }
        return new FollowersListDTO(userId, user.getName(), listOfFollowers);
        //refactor para que no haya dos return?
        //tirar excepción si la string de order es otra?
    }

    @Override
    public FollowedListDTO getFollowed(int userId, Optional<String> order) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowed = new ArrayList<>(user.getFollowed().values());
        if (order.isEmpty()) return new FollowedListDTO(userId, user.getName(), listOfFollowed);
        if (order.get().equals("name_asc")) {
            listOfFollowed.sort(Comparator.comparing(User::getName));
        }
        else if (order.get().equals("name_desc")) {
            listOfFollowed.sort(Comparator.comparing(User::getName).reversed());
        }
        return new FollowedListDTO(userId, user.getName(), listOfFollowed);
        //refactor para que no haya dos return?
        //tirar excepción si la string de order es otra?

    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        User user = this.userRepository.find(userId).orElseThrow();
        //tirar not found exception
        List<User> listOfFollowers = new ArrayList<>(user.getFollowers().values());
        return new FollowersCountDTO(userId, user.getName(), listOfFollowers);
    }
}
