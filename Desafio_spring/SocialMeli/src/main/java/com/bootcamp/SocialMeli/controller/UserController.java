package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    IUserService service;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity followUser(@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_follow") Integer userIdToFollow) {
        service.followUser(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity unfollowUser(@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_unfollow") Integer userIdToUnfollow) {
        service.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity countFollowers(@PathVariable("user_id") Integer userId){
        FollowerCountDTO dto = service.countFollowers(userId);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity getFollowed(@PathVariable("user_id") Integer userId, @RequestParam(required = false) String order){
        FollowedDTO dto = service.getFollowed(userId, order);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity getFollowers(@PathVariable("user_id") Integer userId, @RequestParam(required = false) String order){
        FollowersDTO dto = service.getFollowers(userId, order);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @PostMapping(path="/products/post")
    public ResponseEntity newPublication(@RequestBody PostDTO dto){
        service.newPublication(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/products/followed/{user_id}/list")
    public ResponseEntity getPostsList(@PathVariable("user_id") Integer userId, @RequestParam(required = false) String order){
        PostsListDTO dto = service.getPostsList(userId, order);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

}
