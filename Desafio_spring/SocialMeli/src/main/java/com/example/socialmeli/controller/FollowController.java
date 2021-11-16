package com.example.socialmeli.controller;

import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;
import com.example.socialmeli.service.IFollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowController {
    IFollowService followService;

    public FollowController(IFollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> follow(@PathVariable(name = "user_id") Integer userId,
                                    @PathVariable(name = "user_id_to_follow") Integer followId) {
        followService.addFollow(userId, followId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<FollowerCountDTO> countFollowers(@PathVariable(name = "user_id") Integer userId) {
        return new ResponseEntity<>(followService.followerCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<FollowerListDTO> followerList(@PathVariable(name = "user_id") Integer userId) {
        return new ResponseEntity<>(followService.followerList(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<FollowerListDTO> followedList(@PathVariable(name = "user_id") Integer userId) {
        return new ResponseEntity<>(followService.followingList(userId), HttpStatus.OK);
    }
}
