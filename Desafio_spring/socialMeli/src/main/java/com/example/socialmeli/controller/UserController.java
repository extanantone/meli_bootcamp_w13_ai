package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostRequestResponseDto;
import com.example.socialmeli.dto.UserResponseDto;
import com.example.socialmeli.model.User;
import com.example.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<PostRequestResponseDto> followUser (@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow){
        PostRequestResponseDto response = userService.followUser(user_id,user_id_to_follow);
        return new ResponseEntity(response, HttpStatus.OK);
    }
//TODO verificar el follow al mismo usuario
//TODO Revisar orden alfabetico
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<UserResponseDto> getFollowersCount(@PathVariable Integer user_id){
        UserResponseDto response = userService.getFollowersCount(user_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<UserResponseDto> getFollowersList(@PathVariable Integer user_id, @RequestParam(name="order",required = false) String order){
        UserResponseDto response = userService.getFollowersList(user_id,order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<UserResponseDto> getFollowedList(@PathVariable Integer user_id, @RequestParam(name="order",required = false) String order){
        UserResponseDto response = userService.getFollowedList(user_id,order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Map<Integer, User>> test (){
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<PostRequestResponseDto> unfollow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_unfollow){
        PostRequestResponseDto response = userService.unfollow(user_id,user_id_to_unfollow);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
