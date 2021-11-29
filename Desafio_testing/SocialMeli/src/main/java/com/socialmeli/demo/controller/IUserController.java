package com.socialmeli.demo.controller;

import com.socialmeli.demo.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("users")
@Validated
public interface IUserController {


    @GetMapping("getUser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id);

    @GetMapping("getUsers")
    public ResponseEntity<List<UserDTO>> getUsers();

    @GetMapping("{user_id}/followers/count")
    public ResponseEntity<UserWithFollowersCountDTO> getUserFollowersCount(@PathVariable("user_id") Integer userId);

    @GetMapping("{user_id}/followers/list")
    public  ResponseEntity<UserFollowersDTO> getUserFollowersList(@PathVariable("user_id") Integer userId,
                                                                  @RequestParam(value = "order", required = false) String order);

    @GetMapping("{user_id}/followed/list")
    public  ResponseEntity<UserFollowedDTO> getUserFollowedList(@PathVariable("user_id") Integer userId,
                                                                @RequestParam(value = "order", required = false) String order);

    @PostMapping("addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid AddUserDTO addUserDTO);

    @PostMapping("{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<UserFollowedDTO> followUser(@PathVariable("user_id") Integer userId,
                                                      @PathVariable("user_id_to_follow") Integer userIdToFollow);

    @PostMapping("{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<Void> unfollowUser(@PathVariable("user_id") Integer userId,
                                             @PathVariable("user_id_to_unfollow") Integer userIdToUnfollow);


}
