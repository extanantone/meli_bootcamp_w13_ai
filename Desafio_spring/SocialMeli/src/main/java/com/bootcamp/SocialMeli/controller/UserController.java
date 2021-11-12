package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Void> follow(
            @PathVariable int user_id,
            @PathVariable int user_id_to_follow) {
        userService.follow(user_id, user_id_to_follow);
        return new ResponseEntity(HttpStatus.OK);
    }
    //catchear errores y agregar subclases de excepciones

    @GetMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<Void> unfollow(
            @PathVariable int user_id,
            @PathVariable int user_id_to_unfollow) {
        userService.unfollow(user_id, user_id_to_unfollow);
        return new ResponseEntity(HttpStatus.OK);
    }

}
