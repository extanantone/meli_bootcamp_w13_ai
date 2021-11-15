package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.SocialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {
    @Autowired
    ISocialMeliService SmService;

    //US 0001
    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<ResponseUserDTO> follow(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws NotFoundException {
        return new ResponseEntity<>(SmService.follow(user_id, user_id_to_follow), HttpStatus.OK);
    }

    //US 0002
    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<CountFollowDTO> count(@PathVariable int user_id) throws NotFoundException {
        return new ResponseEntity<>(SmService.count(user_id), HttpStatus.OK);
    }

    //US 0003
    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<FollowersDTO> followers(@PathVariable int user_id) throws NotFoundException {
        return new ResponseEntity<>(SmService.searchFollower(user_id), HttpStatus.OK);
    }

    //US 0004
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<FollowedDTO> followed(@PathVariable int user_id) throws NotFoundException {
        return new ResponseEntity<>(SmService.searchFollowed(user_id), HttpStatus.OK);
    }

    //US 0005
    @PostMapping("/products/post")
    public ResponseEntity<ResponseUserDTO> post(@RequestBody PostDTO post) throws NotFoundException {
        return new ResponseEntity<>(SmService.createPost(post), HttpStatus.OK);
    }

}
