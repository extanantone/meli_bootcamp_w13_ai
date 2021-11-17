package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.UserFollowersDTO;
import com.bootcamp.socialmeli.dto.UserTotalFollowersDTO;
import com.bootcamp.socialmeli.exception.NotFoundUserException;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController{

    @Autowired
    IUserService iUserService;

    //@Override
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public void followUser(
            @PathVariable("user_id") int userId,
            @PathVariable("user_id_to_follow") int userIdToFollow) throws NotPossibleOperationException {
        iUserService.followUser(userId, userIdToFollow);
    }

    //@Override
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserTotalFollowersDTO> getTotalUserFollowers(
            @PathVariable("user_id") int userId) throws NotPossibleOperationException {

        return new ResponseEntity<>(iUserService.getTotalUserFollowers(userId), HttpStatus.OK);
    }

    //@Override
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<UserFollowersDTO> getUserFollowers(
            @PathVariable("user_id") int userId,
            @RequestParam(required = false) String order) throws NotPossibleOperationException {

            return new ResponseEntity<>(iUserService.getUsersFollowers(userId, order), HttpStatus.OK);
    }

    //@Override
    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity getUserFollowed(
            @PathVariable("user_id") int userId,
            @RequestParam(required = false) String order) throws NotPossibleOperationException {

            return new ResponseEntity<>(iUserService.getUsersFollowed(userId, order),HttpStatus.OK);
    }

    //@Override
    @GetMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public void unfollowUser(
            @PathVariable("user_id") int userId,
            @PathVariable("user_id_to_unfollow") int userIdToUnfollow) throws NotPossibleOperationException {

        iUserService.unfollowUser(userId, userIdToUnfollow);
    }

}
