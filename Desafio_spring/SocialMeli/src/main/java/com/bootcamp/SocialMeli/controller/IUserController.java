package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface IUserController {

    @GetMapping("users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<Void> follow(
            @PathVariable int user_id,
            @PathVariable int user_id_to_follow);

    @GetMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<Void> unfollow(
            @PathVariable int user_id,
            @PathVariable int user_id_to_unfollow);

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowersListDTO> getFollowers(
            @PathVariable int user_id,
            @RequestParam Optional<String> order);

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedListDTO> getFollowed(
            @PathVariable int user_id,
            @RequestParam Optional<String> order);

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> getFollowersCount(
            @PathVariable int user_id);
}
