package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserNotFoundException;
import com.lgoyenechea.socialmeli.exception.UserNotFollowException;
import com.lgoyenechea.socialmeli.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserDTO> newUser(@Valid @RequestBody UserCreationDTO newUser) {
        UserDTO user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<UserFollowDTO> follow(@PathVariable @NotNull Long userId,
                                         @PathVariable @NotNull Long userIdToFollow)
            throws UserNotFoundException {

        UserFollowDTO follow = userService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable @NotNull Long userId)
            throws UserNotFoundException {

        UserFollowersCountDTO userFollowersCount = userService.followersCount(userId);
        return new ResponseEntity<>(userFollowersCount, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    ResponseEntity<UserFollowersListDTO> followersList(@PathVariable @NotNull Long userId,
                                                       @RequestParam(defaultValue = "name_asc") String order)
            throws UserNotFoundException {

        UserFollowersListDTO userFollowersList = userService.followersList(userId, order);
        return new ResponseEntity<>(userFollowersList, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    ResponseEntity<UserFollowedListDTO> followedList(@PathVariable @NotNull Long userId,
                                                     @RequestParam(defaultValue = "name_asc") String order)
            throws UserNotFoundException {

        UserFollowedListDTO userFollowedList = userService.followedList(userId, order);
        return new ResponseEntity<>(userFollowedList, HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<UserUnfollowDTO> unfollow(@PathVariable @NotNull Long userId,
                                             @PathVariable @NotNull Long userIdToUnfollow)
            throws UserNotFollowException {

        UserUnfollowDTO unfollowDto = userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(unfollowDto, HttpStatus.OK);
    }
}
