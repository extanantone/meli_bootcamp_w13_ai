package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import com.bootcamp.SocialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("preload")
    public ResponseEntity<Void> preload(){
        userService.create(1, "Juan", true);
        userService.create(2, "Pedro", true);
        userService.create(3, "Agustina", false);
        userService.create(4, "Azul", false);
        return new ResponseEntity(HttpStatus.OK);
        //pasar esto a un json?
        //tenerlos creados desde antes en el repository?
    }

    @GetMapping("users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Void> follow(
            @PathVariable int user_id,
            @PathVariable int user_id_to_follow) {
        //chequear que input no sea nulo, o tirar excepción
        userService.follow(user_id, user_id_to_follow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<Void> unfollow(
            @PathVariable int user_id,
            @PathVariable int user_id_to_unfollow) {
        //chequear input o tirar excepción
        userService.unfollow(user_id, user_id_to_unfollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowers(
            @PathVariable int user_id) {
        //chequear input o tirar excepción
        FollowersListDTO followersList = userService.getFollowers(user_id);
        return new ResponseEntity<>(followersList, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowed(
            @PathVariable int user_id) {
        //chequear input ok o tirar excepción
        FollowedListDTO followedList = userService.getFollowed(user_id);
        return new ResponseEntity<>(followedList, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(
            @PathVariable int user_id) {
        //chequear input ok o tirar excepción
        FollowersCountDTO followersCount = userService.getFollowersCount(user_id);
        return new ResponseEntity<>(followersCount, HttpStatus.OK);
    }



}
