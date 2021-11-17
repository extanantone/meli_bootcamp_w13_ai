package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.exception.UserDoesNotExistsException;
import com.lgoyenechea.socialmeli.exception.UserDoesNotFollowException;
import com.lgoyenechea.socialmeli.service.UserService;
import org.jetbrains.annotations.NotNull;
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

    private void validateId(Long id) throws UserArgumentNotValidException {
        if (id < 1) throw new UserArgumentNotValidException("Invalid user id.");
    }

    @PostMapping
    ResponseEntity<UserDTO> newUser(@RequestBody UserCreationDTO newUser)
            throws UserArgumentNotValidException {

        if (newUser.getUserName() == null || newUser.getUserName().equals(""))
            throw new UserArgumentNotValidException("Invalid user name.");

        UserDTO user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<UserFollowDTO> follow(@PathVariable @NotNull Long userId,
                                         @PathVariable @NotNull Long userIdToFollow)
            throws UserArgumentNotValidException, UserDoesNotExistsException {

        validateId(userId);
        if (userId.equals(userIdToFollow))
            throw new UserArgumentNotValidException("Users id cannot match.");

        UserFollowDTO follow = userService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable @NotNull Long userId)
            throws UserArgumentNotValidException, UserDoesNotExistsException {

        validateId(userId);
        UserFollowersCountDTO userFollowersCount = userService.followersCount(userId);
        return new ResponseEntity<>(userFollowersCount, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    ResponseEntity<UserFollowersListDTO> followersList(@PathVariable @NotNull Long userId,
                                                       @RequestParam(defaultValue = "name_asc") String order)
            throws UserArgumentNotValidException, UserDoesNotExistsException {
        validateId(userId);
        UserFollowersListDTO userFollowersList = userService.followersList(userId, order);
        return new ResponseEntity<>(userFollowersList, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    ResponseEntity<UserFollowedListDTO> followedList(@PathVariable @NotNull Long userId,
                                                     @RequestParam(defaultValue = "name_asc") String order)
            throws UserArgumentNotValidException, UserDoesNotExistsException {
        validateId(userId);
        UserFollowedListDTO userFollowedList = userService.followedList(userId, order);
        return new ResponseEntity<>(userFollowedList, HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<UserUnfollowDTO> unfollow(@PathVariable @NotNull Long userId,
                                             @PathVariable @NotNull Long userIdToUnfollow)
            throws UserArgumentNotValidException, UserDoesNotFollowException {

        if (userId.equals(userIdToUnfollow))
            throw new UserArgumentNotValidException("Users id can not match.");

        validateId(userId);
        validateId(userIdToUnfollow);
        UserUnfollowDTO unfollowDto = userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(unfollowDto, HttpStatus.OK);
    }
}
