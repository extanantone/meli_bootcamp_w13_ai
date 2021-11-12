package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserDTO create(@RequestBody UserDTO user){
        return userService.create(user);
    }

    @PostMapping("users/{user_id}/follow/{user_id_to_follow}")
    public UserDTO followUser(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow, HttpServletResponse response) throws IOException {
        UserDTO user = userService.followUser(user_id,user_id_to_follow);
        return user;
    }
}
