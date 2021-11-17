package com.SocialMeli.controller;

import com.SocialMeli.dto.*;
import com.SocialMeli.exceptions.BadRequestException;
import com.SocialMeli.service.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    final
    UserServiceI service;

    public UserController(UserServiceI service) {
        this.service = service;
    }

    @PostMapping(path = "/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return service.followUser(userId, userIdToFollow);
    }

    @GetMapping(path = "/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId) {
        return service.getFollowersCount(userId);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(service.getUsersDTO(), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowersList(@PathVariable int userId,
                                                         @RequestParam(required = false) String order) {
        if (Objects.isNull(order) || order.equals("name_asc") || order.equals("name_desc")) {
            return service.getSellerFollowersList(userId, order);
        } else {
            throw new BadRequestException("Order requested is not valid");
        }
    }

    @GetMapping(path = "/users/{userId}/followed/list")
    public ResponseEntity<FollowedUsersDTO> getFollowedUsersList(@PathVariable int userId,
                                                                 @RequestParam(required = false) String order) {
        if (Objects.isNull(order) || order.equals("name_asc") || order.equals("name_desc")) {
            return service.getFollowedSellersList(userId, order);
        } else {
            throw new BadRequestException("Order requested is not valid");
        }
    }

    @PostMapping(path = "/products/post")
    public ResponseEntity<String> createPost(@RequestBody PostDTO newPost) {
        return service.createPost(newPost);
    }

    @GetMapping(path = "/products/followed/{userId}/list")
    public ResponseEntity<List<PostsListDTO>> getRecentFollowedSellersPosts(
            @PathVariable int userId, @RequestParam(required = false) String order) {
        if (Objects.isNull(order) || order.equals("date_desc")) {
            return service.getRecentFollowedSellersPosts(userId);
        } else if (order.equals("date_asc")) {
            return service.getRecentFollowedSellersPostsReverse(userId);
        } else {
            System.out.println(order);
            throw new BadRequestException("Order requested is not valid");
        }
    }

    @PostMapping(path = "/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return service.unfollowUser(userId, userIdToUnfollow);
    }

    @PostMapping(path = "/products/promo-post")
    public ResponseEntity<String> createPromoPost(@RequestBody PromoPostDTO newPromoPost) {
        return service.createPromoPost(newPromoPost);
    }

    @GetMapping(path = "/products/{userId}/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> getPromoProductsCount(@PathVariable int userId) {
        return service.getPromoProductsCount(userId);
    }

    @GetMapping(path = "/products/{userId}/list")
    public ResponseEntity<PromoPostsListDTO> getPromoProductsList(@PathVariable int userId) {
        return service.getPromoProductsList(userId);
    }
}
