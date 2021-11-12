package com.example.SocialMeli.controller;

import com.example.SocialMeli.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Boolean> saveFollow(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws Exception {
        return ResponseEntity.ok(this.userService.saveFollow(user_id, user_id_to_follow));
    }
}
