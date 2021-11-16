package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.UserFollowedDTO;
import com.bootcamp.socialmeli.dto.UserFollowersDTO;
import com.bootcamp.socialmeli.dto.UserListDTO;
import com.bootcamp.socialmeli.dto.UserTotalFollowersDTO;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//public class UserController implements IUserController{
public class UserController{

    @Autowired
    IUserService iUserService;

    //@Override
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public void followUser(@PathVariable("user_id") int userId, @PathVariable("user_id_to_follow") int userIdToFollow){
        iUserService.followUser(userId, userIdToFollow);
    }

    //@Override
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity getTotalUserFollowers(@PathVariable("user_id") int userId) {
        return ResponseEntity.ok().body(iUserService.getTotalUserFollowers(userId));
    }

    //@Override
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity getUserFollowers(@PathVariable("user_id") int userId,
                                           @RequestParam(required = false) String order) {
        if (order == null){
            return ResponseEntity.ok().body(iUserService.getUsersFollowers(userId));
        } else {
            return ResponseEntity.ok().body(iUserService.getUsersFollowers(userId, order));
        }

    }

    //@Override
    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity getUserFollowed(@PathVariable("user_id") int userId,
                                          @RequestParam(required = false) String order) {
        if (order == null) {
            return ResponseEntity.ok().body(iUserService.getUsersFollowed(userId));
        } else {
            return ResponseEntity.ok().body(iUserService.getUsersFollowed(userId, order));
        }
    }

    //@Override
    @GetMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public void unfollowUser(@PathVariable("user_id") int userId,@PathVariable("user_id_to_unfollow") int userIdToUnfollow) {
        iUserService.unfollowUser(userId, userIdToUnfollow);
    }

}
