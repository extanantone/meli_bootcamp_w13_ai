package com.SocialMeli.controller;

import com.SocialMeli.dto.*;
import com.SocialMeli.service.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    final
    UserServiceI service;

    public UserController(UserServiceI service) {
        this.service = service;
    }

    @PostMapping(path = "/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable Integer userId,
                                             @PathVariable Integer userIdToFollow) {
        return service.followUser(userId, userIdToFollow);
    }

    @GetMapping(path = "/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable Integer userId) {
        return service.getFollowersCount(userId);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(service.getUsersDTO(), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowersList(@PathVariable Integer userId,
                                                         @RequestParam String order) {

        return service.getSellerFollowersList(userId, order);

    }

    @GetMapping(path = "/users/{userId}/followed/list")
    public ResponseEntity<FollowedUsersDTO> getFollowedUsersList(@PathVariable Integer userId,
                                                                 @RequestParam String order) {
        return service.getFollowedSellersList(userId, order);
    }

    @PostMapping(path = "/products/post")
    public ResponseEntity<String> createPost(@RequestBody @Valid PostDTO newPost) {
        return service.createPost(newPost);
    }

    @GetMapping(path = "/products/followed/{userId}/list")
    public ResponseEntity<List<PostsListDTO>> getFollowedSellersRecentPosts(
            @PathVariable Integer userId,
            @RequestParam String order) {

        return service.getFollowedSellersRecentPosts(userId, order);

    }

    @PostMapping(path = "/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable Integer userId,
                                               @PathVariable Integer userIdToUnfollow) {
        return service.unfollowUser(userId, userIdToUnfollow);
    }

    @PostMapping(path = "/products/promo-post")
    public ResponseEntity<String> createPromoPost(@RequestBody @Valid PromoPostDTO newPromoPost) {
        return service.createPromoPost(newPromoPost);
    }

    @GetMapping(path = "/products/{userId}/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(@PathVariable Integer userId) {
        return service.getPromoProductsCount(userId);
    }

    @GetMapping(path = "/products/{userId}/list")
    public ResponseEntity<PromoPostsListDTO> getPromoProductsList(@PathVariable Integer userId) {
        return service.getPromoProductsList(userId);
    }
}
