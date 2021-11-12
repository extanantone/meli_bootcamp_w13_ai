package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserDTO> newUser(@RequestBody UserCreationDTO newUser) throws UserArgumentNotValidException {
        UserDTO user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<UserFollowDTO> follow(@PathVariable Long userId,
                                         @PathVariable Long userIdToFollow) throws UserArgumentNotValidException {
        UserFollowDTO follow = userService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable Long userId) {
        UserFollowersCountDTO userFollowersCount = userService.followersCount(userId);
        return new ResponseEntity<>(userFollowersCount, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    ResponseEntity<UserFollowersListDTO> followersList(@PathVariable Long userId) {
        UserFollowersListDTO userFollowersList = userService.followersList(userId);
        return new ResponseEntity<>(userFollowersList, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    ResponseEntity<UserFollowedListDTO> followedList(@PathVariable Long userId) {
        UserFollowedListDTO userFollowedList = userService.followedList(userId);
        return new ResponseEntity<>(userFollowedList, HttpStatus.OK);
    }
}
