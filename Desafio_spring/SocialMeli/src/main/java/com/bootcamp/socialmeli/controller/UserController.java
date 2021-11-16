package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.UserCreationDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.dto.UserWithFollowedDTO;
import com.bootcamp.socialmeli.dto.UserWithFollowersDTO;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(
                userService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id) {
        return new ResponseEntity<>(
                userService.getUser(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreationDTO userCreationDTO) {
        return new ResponseEntity<>(
                userService.createUser(userCreationDTO),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{followerId}/follow/{followedId}")
    public ResponseEntity<Void> followUser(@PathVariable long followerId, @PathVariable long followedId) {
        userService.followUser(followerId, followedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/followers/count")
    public ResponseEntity<Integer> getFollowerCount(@PathVariable long id) {
        return new ResponseEntity<>(
                userService.getFollowerCount(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}/followers/list")
    public ResponseEntity<UserWithFollowersDTO> getFollowerList(@PathVariable long id) {
        return new ResponseEntity<>(
                userService.getFollowers(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}/followed/count")
    public ResponseEntity<Integer> getFollowedCount(@PathVariable long id) {
        return new ResponseEntity<>(
                userService.getFollowedCount(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}/followed/list")
    public ResponseEntity<UserWithFollowedDTO> getFollowedList(@PathVariable long id) {
        return new ResponseEntity<>(
                userService.getFollowed(id),
                HttpStatus.OK
        );
    }
}
