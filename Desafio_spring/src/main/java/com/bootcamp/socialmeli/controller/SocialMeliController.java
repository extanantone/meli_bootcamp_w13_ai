package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.DTO.DTOFollowers;
import com.bootcamp.socialmeli.service.IServiceFollower;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {

    @Autowired
    IServiceFollower iServiceFollower;

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
    public ResponseEntity<DTOFollowers> getFollowersFromUser(@PathVariable int userId){

        return iServiceFollower.getFollowersFromUser(userId);
    }

}
