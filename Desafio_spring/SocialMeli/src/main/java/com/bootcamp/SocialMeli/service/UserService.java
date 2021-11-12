package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import com.bootcamp.SocialMeli.model.Seller;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void follow(int followerId, int followedId) {
        User follower = this.userRepository.find(followerId).orElseThrow();
        //tirar excepción si no es vendedor
        Seller followed = (Seller) this.userRepository.find(followedId).orElseThrow();

        follower.addFollowed(followed);
        followed.addFollower(followed);
    }

    @Override
    public void unfollow(int followerId, int followedId) {
        User follower = this.userRepository.find(followerId).orElseThrow();
        Seller followed = (Seller) this.userRepository.find(followedId).orElseThrow();

        follower.removeFollowed(followedId);
        followed.removeFollower(followerId);

    }

    @Override
    public FollowersListDTO getFollowers(int sellerId) {
        Seller seller = (Seller) this.userRepository.find(sellerId).orElseThrow();
        List<User> listOfFollowers = (List<User>) seller.getFollowers().values();
        return new FollowersListDTO(sellerId, seller.getName(), listOfFollowers);
    }

    @Override
    public FollowedListDTO getFollowed(int userId) {
        User user = this.userRepository.find(userId).orElseThrow();
        List<Seller> listOfFollowed = (List<Seller>) user.getFollowed().values();
        return new FollowedListDTO(userId, user.getName(), listOfFollowed);
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        return null;
    }
}
