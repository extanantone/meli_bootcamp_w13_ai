package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createBuyers(UserDTO user) {
        return userRepository.createBuyers(user);
    }

    @Override
    public UserDTO createSellers(UserDTO user) {
        return userRepository.createSellers(user);
    }

    /*@Override
    public Boolean followUser(Integer user_id, Integer user_id_to_follow) {
        return userRepository.follow(user_id, user_id_to_follow);
    }

    @Override
    public FollowersCountDTO followersCount(Integer user_id) {
        return userRepository.followersCount(user_id);
    }

    @Override
    public SellersDTO followersList(Integer user_id) {
        return userRepository.followersList(user_id);
    }*/
}
