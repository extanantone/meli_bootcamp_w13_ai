package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.service.ISocialMeliService;
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
    private ISocialMeliService socialMeliService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> followVendedor(@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_follow") Integer userIdToFollow){
        return new ResponseEntity<>(this.socialMeliService.followVendedor(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<?> getCantSeguidores(@PathVariable("user_id") Integer userId){
        this.socialMeliService.getCantSeguidores(userId);
        return null;
    }


    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unfollowVendedor(@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_unfollow") Integer userIdToUnfollow){
        return new ResponseEntity<>(this.socialMeliService.unfollowVendedor(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
