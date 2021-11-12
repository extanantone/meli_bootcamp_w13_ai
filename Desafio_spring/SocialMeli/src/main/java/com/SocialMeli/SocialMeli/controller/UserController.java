package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.FollowersCountDTO;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;
import com.SocialMeli.SocialMeli.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/followed/create")
    public UserDTO createBuyers(@RequestBody UserDTO user){
        return userService.createBuyers(user);
    }

    @PostMapping("users/followers/create")
    public UserDTO createSellers(@RequestBody UserDTO user){
        return userService.createSellers(user);
    }

    /*@PostMapping("users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<String> followUser(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow) {
        Boolean statusFollow = userService.followUser(user_id,user_id_to_follow);
        if( statusFollow )
            return new ResponseEntity<>("Usuarios seguidos.", HttpStatus.OK);

        return new ResponseEntity<>("Los usuarios no pueden seguirse.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("users/{user_id}/followers/count")
    public FollowersCountDTO followersCount(@PathVariable Integer user_id){
        return userService.followersCount(user_id);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public SellersDTO followersList(@PathVariable Integer user_id){
        return userService.followersList(user_id);
    }*/
}
