package com.example.socialmeli.controller;

import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;
import com.example.socialmeli.service.IFollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{user_id}" )
public class FollowController {
    IFollowService followService;

    public FollowController(IFollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/follow/{user_id_to_follow}")
    public ResponseEntity<?> follow(@PathVariable(name = "user_id") Integer userId,
                                    @PathVariable(name = "user_id_to_follow") Integer followId) {
        followService.addFollow(userId, followId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowerCountDTO> countFollowers(@PathVariable(name = "user_id") Integer userId) {
        return new ResponseEntity<>(followService.followerCount(userId), HttpStatus.OK);
    }

    @GetMapping("/followers/list")
    public ResponseEntity<FollowerListDTO> followerList(@PathVariable(name = "user_id") Integer userId,
                                                        @RequestParam(required = false) String order) {
        if (order == null) { return new ResponseEntity<>(followService.followerList(userId), HttpStatus.OK); }
        return new ResponseEntity<>(followService.sortedFollowerList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/followed/list")
    public ResponseEntity<FollowerListDTO> followedList(@PathVariable(name = "user_id") Integer userId,
                                                        @RequestParam(required = false) String order) {
        if (order == null) { return new ResponseEntity<>(followService.followingList(userId), HttpStatus.OK); }
        return new ResponseEntity<>(followService.sortedFollowingList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unfollow(@PathVariable(name = "user_id") Integer userId,
                                    @PathVariable(name = "user_id_to_unfollow") Integer unfollowId) {
        followService.removeFollow(userId, unfollowId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
