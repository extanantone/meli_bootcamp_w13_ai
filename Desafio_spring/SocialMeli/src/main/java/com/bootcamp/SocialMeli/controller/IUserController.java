package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedListDTO;
import com.bootcamp.SocialMeli.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli.dto.FollowersListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IUserController {
    @GetMapping("preload")
    public ResponseEntity<Void> preload();

    @GetMapping("users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Void> follow();
    //catchear errores y agregar subclases de excepciones

    @GetMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<Void> unfollow();

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowers();

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowed();

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount();
}
