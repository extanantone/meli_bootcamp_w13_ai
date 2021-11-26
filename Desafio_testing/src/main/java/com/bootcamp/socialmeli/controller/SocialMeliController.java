package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.*;
import com.bootcamp.socialmeli.service.IServiceFollowed;
import com.bootcamp.socialmeli.service.IServiceFollower;
import com.bootcamp.socialmeli.service.IServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class SocialMeliController {

    @Autowired
    IServiceFollower iServiceFollower;

    @Autowired
    IServiceFollowed iServiceFollowed;

    @Autowired
    IServicePost iServicePost;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity userToFollow(@PathVariable int user_id, @PathVariable int user_id_to_follow){

        return iServiceFollower.userToFollow(user_id,user_id_to_follow);

    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<DTOCount> countFollowersOfUser(@PathVariable int user_id){

            return iServiceFollower.getCountFollowersOfuser(user_id);
    }

    @GetMapping("/user/{user_id}/followers/list")
    public ResponseEntity<DTOFollower> getFollowersFromUser(@PathVariable int user_id,
                                       @RequestParam(defaultValue = "name_desc") String order){

        order = order.toLowerCase();

        return iServiceFollower.getFollowersFromUser(user_id, order);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<DTOFollowed> getFolloweds(@PathVariable int user_id,
                                       @RequestParam(defaultValue = "name_desc") String order){

        order = order.toLowerCase();

        return iServiceFollowed.getFolloweds(user_id, order);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity userToUnfollow(@PathVariable int user_id, @PathVariable int user_id_to_follow){

        try {
            return iServiceFollower.userToUnfollow(user_id,user_id_to_follow);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encuentra el usuario");
        }
    }

    @PostMapping("/products/newpost")
    public ResponseEntity newPost(@Valid @RequestBody DTOPostProduct postProduct){

        return iServicePost.createPost(postProduct);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<DTOPublishFollowed> getPosts(@PathVariable int user_id, @RequestParam(defaultValue = "date_desc") String order){

        order = order.toLowerCase();

        return iServiceFollowed.getPostFollowed(user_id, order);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity newPostPromo(@Valid @RequestBody DTOPostProduct postProduct){

        return iServicePost.createPostPromo(postProduct);
    }

    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<DTOCountpromo> countPostPromo(@PathVariable int user_id){

        return iServicePost.countPostPromo(user_id);
    }

    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<DTOPromoPost> getPromoPost(@PathVariable int user_id){

        return iServicePost.getPostPromo(user_id);
    }

}
