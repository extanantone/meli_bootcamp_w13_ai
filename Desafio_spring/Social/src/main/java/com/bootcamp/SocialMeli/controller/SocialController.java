package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.CountFollowersDTO;
import com.bootcamp.SocialMeli.dto.FollowedsDTO;
import com.bootcamp.SocialMeli.dto.FollowersDTO;
import com.bootcamp.SocialMeli.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialController {

    com.bootcamp.SocialMeli.service.ISocialService socialService;

    public SocialController(com.bootcamp.SocialMeli.service.ISocialService socialService) {
        this.socialService = socialService;
    }

    // PING-PONG
    @GetMapping("/ping")
    public ResponseEntity<String> ping(){

        return new ResponseEntity<>("Pong", HttpStatus.OK);
    }

    // 1
    @GetMapping("/users/{id_Buyer}/follow/{id_Seller}")
    public ResponseEntity<com.bootcamp.SocialMeli.dto.FollowDTO> getfollow(
            @PathVariable int id_Buyer,@PathVariable int id_Seller) throws com.bootcamp.SocialMeli.exception.NotFoundUserException {

        return new ResponseEntity<>(
                socialService.follow(id_Buyer,id_Seller), HttpStatus.OK
        );


    }

    // 2
    // /users/{user_id}/followers/count
    @GetMapping("/users/{seller_id}/followers/count")
    public ResponseEntity<CountFollowersDTO> getfollowersCount(
            @PathVariable int seller_id) throws com.bootcamp.SocialMeli.exception.NotFoundUserException {

        return new ResponseEntity<>(
                socialService.getFollowersCount(seller_id) , HttpStatus.OK
        );


    }

    // 3
    // /users/{user_id}/followers/list
    @GetMapping("/users/{buyer_id}/followers/list")
    public ResponseEntity<FollowersDTO> getfollowers(
            @PathVariable int buyer_id) throws NotFoundUserException {

        return new ResponseEntity<FollowersDTO>(
                socialService.getFollowers(buyer_id), HttpStatus.OK

        );
    }

    // 4
    // /users/{user_id}/followed/list
    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<FollowedsDTO> getfolloweds(
            @PathVariable int user_id) throws NotFoundUserException {
        return new ResponseEntity<FollowedsDTO>(
                socialService.getFolloweds(user_id),HttpStatus.OK
        );
    }








}
