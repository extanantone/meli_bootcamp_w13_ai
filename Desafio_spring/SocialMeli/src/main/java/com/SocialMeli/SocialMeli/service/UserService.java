package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;
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

    @Override
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
    }

    @Override
    public BuyersDTO followedList(Integer user_id) {
        return userRepository.followedList(user_id);
    }

    @Override
    public Boolean createPost(PostUserDTO post) {
        return userRepository.createPost(post);
    }

    @Override
    public PostListDTO postList(Integer user_id, String order) {
        return userRepository.postList(user_id, order);
    }

    @Override
    public Boolean unfollowUser(Integer user_id, Integer user_id_to_unfollow) {
        return userRepository.unfollow(user_id, user_id_to_unfollow);
    }

    @Override
    public BuyersDTO followedListSorted(Integer userId, String order) {
        return userRepository.followedListSorted(userId, order);
    }

    @Override
    public SellersDTO followersListSorted(Integer userId, String order) {
        return userRepository.followersListSorted(userId, order);
    }

    @Override
    public PostListDTO productsListSorted(Integer user_id, String order) {
        return userRepository.productsListSorted(user_id, order);
    }

    // BONUS
    @Override
    public Boolean createPostPromo(PostPromoUserDTO post) {
        return userRepository.createPostPromo(post);
    }

    @Override
    public PostPromoCountDTO postPromoCount(Integer userId) {
        return userRepository.postPromoCount(userId);
    }

    @Override
    public PostPromoListDTO postPromoList(Integer userId) {
        return userRepository.postPromoList(userId);
    }
}
