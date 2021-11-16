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

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<?> newFollow(@PathVariable int user_id,@PathVariable int user_id_to_follow){
        return new ResponseEntity(userService.addFollower(user_id,user_id_to_follow), HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/count")
    ResponseEntity<?> countFollowers(@PathVariable int user_id){
        return new ResponseEntity(userService.countFollowersUser(user_id),HttpStatus.OK);
    }

    @GetMapping("/{user_id}/followers/list")
    ResponseEntity<?> listFollowers(@PathVariable int user_id,@RequestParam(required = false) String order){
        return new ResponseEntity(userService.listUserFollowex(user_id,true,order),HttpStatus.OK);
    }
    @GetMapping("/{user_id}/followed/list") //order=name_asc
    ResponseEntity<?> listFollowed(@PathVariable int user_id,@RequestParam(required = false) String order){
        return new ResponseEntity(userService.listUserFollowex(user_id,false,order),HttpStatus.OK);
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<?> unfollow(@PathVariable int user_id,@PathVariable int user_id_to_unfollow){
        return new ResponseEntity(userService.unfollow(user_id,user_id_to_unfollow), HttpStatus.OK);
    }

}
