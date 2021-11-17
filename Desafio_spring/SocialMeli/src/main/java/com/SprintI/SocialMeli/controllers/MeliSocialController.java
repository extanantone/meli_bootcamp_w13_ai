package com.SprintI.SocialMeli.controllers;

import com.SprintI.SocialMeli.dtos.*;
import com.SprintI.SocialMeli.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeliSocialController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }


    //FOLLOW US 001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public void follow(@PathVariable int userId, @PathVariable int userIdToFollow){
        userService.followUser(userId, userIdToFollow);
    }

    //UNFOLLOW US 007
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        userService.unfollowUser(userId, userIdToUnfollow);
    }

    //COUNT FOLLOWERS US 002
    @GetMapping("/users/{userId}/followers/count")
    public UserCountDTO followers(@PathVariable int userId){
        return  userService.quantityOfFollowers(userId);
    }


    //FOLLOWERS LIST US 003 / 008
    @GetMapping("users/{userID}/followers/list")
    public UserFollowersDTO listFollowers(@PathVariable int userID, @RequestParam(defaultValue = "name_asc") String order){
        return userService.followers(userID, order);
    }


    //FOLLOWED LIST US 004 / 008
    @GetMapping("/users/{userID}/followed/list")
    public UserFollowedDTO listFollowed(@PathVariable int userID, @RequestParam(defaultValue = "name_asc") String order) {
        return userService.followed(userID, order);
    }


    //ADD NEW POST US 005
    @PostMapping("/products/post")
    public void newPost(@RequestBody PostWithoutDiscountDTO postWithoutDiscountDTO) {
        userService.addNewPost(postWithoutDiscountDTO);
    }


    //List Of Post Early 14 Days US 006 / 009
    @GetMapping("/products/followed/{user_id}/list")
    public UserPostDTO findEarlyPost(@PathVariable int user_id,@RequestParam (defaultValue = "date_asc") String order){
        return userService.listPostTwoWeeksEarly(user_id, order);
    }



}
