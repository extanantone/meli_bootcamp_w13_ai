package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.DTO.DTOFollowed;
import com.bootcamp.socialmeli.DTO.DTOFollower;
import com.bootcamp.socialmeli.DTO.DTOPostProduct;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.service.IServiceFollowed;
import com.bootcamp.socialmeli.service.IServiceFollower;
import com.bootcamp.socialmeli.service.IServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    @Autowired
    IServiceFollower iServiceFollower;

    @Autowired
    IServiceFollowed iServiceFollowed;

    @Autowired
    IServicePost iServicePost;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity userToFollow(@PathVariable int userId, @PathVariable int userIdToFollow){

        try {
            return iServiceFollower.userToFollow(userId,userIdToFollow);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encuentra el usuario");
        }

    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<DTOCount> countFollowersOfUser(@PathVariable int userId){

            return iServiceFollower.getCountFollowersOfuser(userId);
    }

    @GetMapping("/user/{userId}/followers/list")
    public ResponseEntity<DTOFollower> getFollowersFromUser(@PathVariable int userId){

        return iServiceFollower.getFollowersFromUser(userId);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<DTOFollowed> getFolloweds(@PathVariable int userId){

        return iServiceFollowed.getFolloweds(userId);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity userToUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){

        try {
            return iServiceFollower.userToUnfollow(userId,userIdToUnfollow);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encuentra el usuario");
        }
    }

    @PostMapping("/products/newpost")
    public ResponseEntity newPost(@RequestBody DTOPostProduct postProduct){

        return iServicePost.createPost(postProduct);

    }

}
