package com.SocialMeli.service;

import com.SocialMeli.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceI {
    List<UserDTO> getUsersDTO();
    ResponseEntity<FollowersCountDTO> getFollowersCount(Integer userId);
    ResponseEntity<String> followUser(Integer userId, Integer userIdToFollow);
    ResponseEntity<String> unfollowUser(Integer userId, Integer userIdToUnfollow);
    ResponseEntity<FollowersDTO> getSellerFollowersList(Integer userId, String order);
    ResponseEntity<FollowedUsersDTO> getFollowedSellersList(Integer userId, String order);
    ResponseEntity<String> createPost(PostDTO newPost);
    ResponseEntity<List<PostsListDTO>> getFollowedSellersRecentPosts(Integer userId, String order);

    ResponseEntity<String> createPromoPost(PromoPostDTO newPromoPost);
    ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(Integer userId);
    ResponseEntity<PromoPostsListDTO> getPromoProductsList(Integer userId);
}
