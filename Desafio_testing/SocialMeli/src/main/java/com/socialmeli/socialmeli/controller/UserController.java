package com.socialmeli.socialmeli.controller;

import com.socialmeli.socialmeli.service.UserAndPostServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserAndPostServiceI userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<?> newFollow(@PathVariable("userId") int user_id,@PathVariable("userIdToFollow") int user_id_to_follow){
        return new ResponseEntity(true, HttpStatus.OK);//userService.addFollower(user_id,user_id_to_follow)
    }

    @GetMapping("/{userId}/followers/count")
    ResponseEntity<?> countFollowers(@PathVariable("userId") int user_id){
        return new ResponseEntity(userService.countFollowersUser(user_id),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> listFollowers(@PathVariable("userId") int user_id,@RequestParam(required = false) String order){
        return new ResponseEntity(userService.listUserFollowex(user_id,true,order),HttpStatus.OK);
    }
    @GetMapping("/{userId}/fxollowed/list") //order=name_asc
    public ResponseEntity<?> listFollowed(@PathVariable("userId") int user_id,@RequestParam(required = false) String order){
        return new ResponseEntity(userService.listUserFollowex(user_id,false,order),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    ResponseEntity<?> unfollow(@PathVariable("userId") int user_id,@PathVariable("userIdToFollow") int user_id_to_unfollow){
        return new ResponseEntity(userService.unfollow(user_id,user_id_to_unfollow), HttpStatus.OK);
    }

}
