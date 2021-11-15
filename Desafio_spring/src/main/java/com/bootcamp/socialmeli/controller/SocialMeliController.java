package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.*;
import com.bootcamp.socialmeli.repository.IPostRepository;
import com.bootcamp.socialmeli.service.IServiceFollowed;
import com.bootcamp.socialmeli.service.IServiceFollower;
import com.bootcamp.socialmeli.service.IServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

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
    public ResponseEntity<DTOFollower> getFollowersFromUser(@PathVariable int userId,
                                       @RequestParam(defaultValue = "name_desc") String order){

        order = order.toLowerCase();

        return iServiceFollower.getFollowersFromUser(userId, order);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<DTOFollowed> getFolloweds(@PathVariable int userId,
                                       @RequestParam(defaultValue = "name_desc") String order){

        order = order.toLowerCase();

        return iServiceFollowed.getFolloweds(userId, order);
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

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<DTOPublishFollowed> getPosts(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order){

        order = order.toLowerCase();

        return iServiceFollowed.getPostFollowed(userId, order);
    }

}
