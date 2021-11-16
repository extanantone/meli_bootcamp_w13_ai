package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/users/{userId}/follow/{user_id_to_follow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId, @PathVariable int user_id_to_follow){
        return new ResponseEntity<MessageDTOResponse>(userService.followSeller(userId, user_id_to_follow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> getSellerCountFollowers(@PathVariable int userId){
        return new ResponseEntity<SellerCountFollowersDTOResponse>(userService.getSellerFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable int user_id, @RequestParam String order){
        return new ResponseEntity<SellerFollowersDTOResponse>(userService.getFollowers(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<?> getFollowed(@PathVariable int user_id){
        return new ResponseEntity<SellersFollowedDTOResponse>(userService.getFollowed(user_id), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unfollowSeller(@PathVariable int userId, @PathVariable int user_id_to_unfollow){
        return new ResponseEntity<MessageDTOResponse>(userService.unfollowSeller(userId, user_id_to_unfollow), HttpStatus.OK);
    }
}
