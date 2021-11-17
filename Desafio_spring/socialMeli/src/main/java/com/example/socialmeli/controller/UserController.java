package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostRequestResponseDto;
import com.example.socialmeli.dto.UserResponseDto;
import com.example.socialmeli.dto.UsersResponseDto;
import com.example.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<PostRequestResponseDto> followUser (@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        PostRequestResponseDto response = userService.followUser(userId,userIdToFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserResponseDto> getFollowersCount(@PathVariable Integer userId){
        UserResponseDto response = userService.getFollowersCount(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserResponseDto> getFollowersList(@PathVariable Integer userId, @RequestParam(name="order",required = false) String order){
        UserResponseDto response = userService.getFollowersList(userId,order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserResponseDto> getFollowedList(@PathVariable Integer userId, @RequestParam(name="order",required = false) String order){
        UserResponseDto response = userService.getFollowedList(userId,order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<UsersResponseDto> test (){
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<PostRequestResponseDto> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnFollow){
        PostRequestResponseDto response = userService.unfollow(userId,userIdToUnFollow);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
//TODO mirar en los dto de resp de follow q si es vacio los devuelva
//TODO agregar query post al get y agregar lapso de tiempo variable