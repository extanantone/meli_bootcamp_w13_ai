package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.dto.user.*;
import com.bootcamp.SocialMeli.service.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable("user_id") int userId,
                                              @PathVariable("user_id_to_follow") int userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<ResponseDTO> unfollow(@PathVariable("user_id") int userId,
                                                @PathVariable("user_id_to_unfollow") int userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable("user_id") int userId) {
        return new ResponseEntity<>(userService.followersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<UserFollowersListDTO> followersList(@PathVariable("user_id") int userId,
                                                              @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.followersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<UserFollowedListDTO> followedList(@PathVariable("user_id") int userId,
                                                            @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.followedList(userId, order), HttpStatus.OK);
    }
}