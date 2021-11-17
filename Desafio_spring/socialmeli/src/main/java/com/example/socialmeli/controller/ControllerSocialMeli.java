package com.example.socialmeli.controller;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.services.IUsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerSocialMeli {

    @Autowired
    IUsersServices service;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> followUser(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow){
        return new ResponseEntity<>(service.followUser(user_id, user_id_to_follow), HttpStatus.OK);
    }


    @PostMapping("/users/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity<?>  unFollowUser(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow){
        return new ResponseEntity<>(service.unFollow(user_id, user_id_to_follow), HttpStatus.OK);
    }


    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<DTOResponseAmountUser> amountFollowers(@PathVariable Integer user_id){
        return new ResponseEntity<DTOResponseAmountUser>(service.getAmountFollowers(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<DTOResponseListUser> listFollowers(@PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order){
        return new ResponseEntity<DTOResponseListUser>(service.getListFollowers(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<DTOResponseListUserFollowed> listFollowed(@PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order){
        return new ResponseEntity<DTOResponseListUserFollowed>(service.getListFollowed(user_id, order), HttpStatus.OK);
    }


    @PostMapping("/products/post")
    public ResponseEntity<?> newPost(@RequestBody DTOproductsRequest product){
        service.createProduct(product);
        return new ResponseEntity<>(new EmptyJsonResponse(), HttpStatus.OK) ;
    }


    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<?> feedFollowed(@PathVariable Integer user_id, @RequestParam(defaultValue = "date_desc") String order){
        return new ResponseEntity<>(service.getFeedProducts(user_id, order), HttpStatus.OK);
    }

}