package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.BasicResponseDTO;
import com.bootcamp.socialmeli.dto.FollowedListResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerCountResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerListResponseDTO;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<BasicResponseDTO> follow(
            @PathVariable("user_id")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userId,
            @PathVariable("user_id_to_follow")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userIdToFollow) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity.ok(new BasicResponseDTO("200", "OK"));
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<BasicResponseDTO> unfollow(
            @PathVariable("user_id")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userId,
            @PathVariable("user_id_to_unfollow")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userIdToUnfollow) {
        userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok(new BasicResponseDTO("200", "OK"));
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowerCountResponseDTO> getFollowersCount(
            @PathVariable("user_id")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userId) {
        return ResponseEntity.ok(userService.followersCount(userId));
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowerListResponseDTO> getFollowersList(
            @PathVariable("user_id")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.followersList(userId, order));
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListResponseDTO> getFollowedList(
            @PathVariable("user_id")
            @NotNull(message = "La id no puede estar vacía.")
            @Positive(message = "El id debe ser mayor a uno") Long userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.followedList(userId, order));
    }
}
