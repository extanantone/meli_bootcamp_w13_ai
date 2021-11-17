package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.BasicResponseDTO;
import com.bootcamp.socialmeli.dto.FollowedListResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerCountResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerListResponseDTO;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<BasicResponseDTO> follow(@PathVariable("user_id") Long userId, @PathVariable("user_id_to_follow") Long userIdToFollow){
        userService.follow(userId, userIdToFollow);
        return ResponseEntity.ok(new BasicResponseDTO("200","OK"));
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<BasicResponseDTO> unfollow(@PathVariable("user_id") Long userId, @PathVariable("user_id_to_unfollow") Long userIdToUnfollow){
        userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok(new BasicResponseDTO("200","OK"));
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowerCountResponseDTO> getFollowersCount(@PathVariable("user_id") Long userId){
        return ResponseEntity.ok(userService.followersCount(userId));
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowerListResponseDTO> getFollowersList(@PathVariable("user_id") Long userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.followersList(userId,order));
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListResponseDTO> getFollowedList(@PathVariable("user_id") Long userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok(userService.followedList(userId,order));
    }
}
