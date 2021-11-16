package com.example.SocialMeli.controller;

import com.example.SocialMeli.dto.UserCountFollowersDTO;
import com.example.SocialMeli.dto.UserFollowersDTO;
import com.example.SocialMeli.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Boolean> saveFollow(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws Exception {
        return ResponseEntity.ok(this.userService.saveFollow(user_id, user_id_to_follow));
    }

    @PostMapping("/{user_id}/unfollow/{id_to_unfollow}")
    public ResponseEntity<Boolean> unfollow(@PathVariable int user_id, @PathVariable int id_to_unfollow) throws Exception {
        return ResponseEntity.ok(this.userService.unfollow(user_id, id_to_unfollow));
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserCountFollowersDTO> countFollowers(@PathVariable int user_id) throws Exception {
        return ResponseEntity.ok(this.userService.countFollowers(user_id));
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<UserFollowersDTO> listFollowers(@PathVariable int user_id) throws Exception {
        return ResponseEntity.ok(this.userService.listFollowers(user_id));
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<UserFollowersDTO> listFolloweds(@PathVariable int user_id) throws Exception {
        return ResponseEntity.ok(this.userService.listFolloweds(user_id));
    }
}
