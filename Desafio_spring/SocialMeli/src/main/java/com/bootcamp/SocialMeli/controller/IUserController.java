package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IUserController {
    @GetMapping("preload")
    ResponseEntity<Void> preload();

    @GetMapping("users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<Void> follow();
    //catchear errores y agregar subclases de excepciones

    @GetMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<Void> unfollow();

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowersListDTO> getFollowers();

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedListDTO> getFollowed();

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> getFollowersCount();
}
