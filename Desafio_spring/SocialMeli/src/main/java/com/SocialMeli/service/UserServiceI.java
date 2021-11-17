package com.SocialMeli.service;

import com.SocialMeli.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceI {
    List<UserDTO> getUsersDTO();
    ResponseEntity<FollowersCountDTO> getFollowersCount(int userId);
    ResponseEntity<String> followUser(int userId, int userIdToFollow);
    ResponseEntity<String> unfollowUser(int userId, int userIdToUnfollow);
    ResponseEntity<FollowersDTO> getSellerFollowersList(int userId, String order);
    ResponseEntity<FollowedUsersDTO> getFollowedSellersList(int userId, String order);
    ResponseEntity<String> createPost(PostDTO newPost);
    ResponseEntity<List<PostsListDTO>> getRecentFollowedSellersPosts(int userId);
    ResponseEntity<List<PostsListDTO>> getRecentFollowedSellersPostsReverse(int userId);

    ResponseEntity<String> createPromoPost(PromoPostDTO newPromoPost);
    ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(int userId);
    ResponseEntity<PromoPostsListDTO> getPromoProductsList(int userId);
}
