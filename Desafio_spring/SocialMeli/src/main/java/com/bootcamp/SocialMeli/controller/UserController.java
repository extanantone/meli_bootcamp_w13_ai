package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.UserCountFollowersDTO;
import com.bootcamp.SocialMeli.service.UserService;
import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.dto.UserFollowedDTO;
import com.bootcamp.SocialMeli.dto.UserFollowersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
   UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<UserDTO> allUsers(){
        return userService.allUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }


//    US 0001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public void followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followUser(userId, userIdToFollow);

    }
//    US 0002
    @GetMapping("/users/{userId}/followers/count/")
    public UserCountFollowersDTO followersCount(@PathVariable int userId)
    {
        return userService.countFollowers(userId);
    }

//    US 0003 - US 0008
    @GetMapping("/users/{userId}/followers/list")
    public UserFollowersDTO orderByFollowers(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order){

        return userService.orderByNameFollowers(userId,order);
    }

//    US 0004  - US 0008

    @GetMapping("/users/{userId}/followed/list")
    public UserFollowedDTO getFollowedList(@PathVariable int userId,@RequestParam(defaultValue = "name_asc") String order){
        return userService.orderByNameFollowed(userId,order);
    }

//    US 0007
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollowUser (@PathVariable int userId,@PathVariable int userIdToUnfollow){
        userService.unfollowUser(userId,userIdToUnfollow);
    }

}
