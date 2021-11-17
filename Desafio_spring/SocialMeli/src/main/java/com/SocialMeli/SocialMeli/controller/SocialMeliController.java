package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.exceptions.NotFoundException;
import com.SocialMeli.SocialMeli.model.Post;
import com.SocialMeli.SocialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.util.List;

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
    public ResponseEntity<FollowersDTO> followers(@PathVariable int user_id,@RequestParam(required = false) String order) throws NotFoundException {
        return new ResponseEntity<>(SmService.searchFollower(user_id, order), HttpStatus.OK);
    }

    //US 0004
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<FollowedDTO> followed(@PathVariable int user_id,@RequestParam(required = false) String order) throws NotFoundException {
        return new ResponseEntity<>(SmService.searchFollowed(user_id, order), HttpStatus.OK);
    }

    //US 0005
    @PostMapping("/products/post")
    public ResponseEntity<ResponseUserDTO> post(@RequestBody PostDTO post) throws NotFoundException {
        return new ResponseEntity<>(SmService.createPost(post), HttpStatus.OK);
    }

    //US 0006
    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<List<PostDTO>> postList(@PathVariable int user_id, @RequestParam(required = false) String order) throws NotFoundException {
        return new ResponseEntity<>(SmService.searchPost(user_id, order), HttpStatus.OK);
    }

    //US 0007
    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<ResponseUserDTO> unfolow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws NotFoundException {
        return new ResponseEntity<>(SmService.unfollow(user_id, user_id_to_unfollow), HttpStatus.OK);
    }
}
