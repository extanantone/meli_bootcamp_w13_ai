package com.example.socialmeli.controller.user;

import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.dto.user.FollowerCountDTO;
import com.example.socialmeli.dto.user.FollowerListDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
public interface IUserController
{
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    FollowedListDTO follow(@PathVariable int userId, @PathVariable int userIdToFollow);

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    FollowedListDTO unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow);

    @GetMapping("/{userId}/followers/count")
    FollowerCountDTO countFollowers(@PathVariable int userId);

    @GetMapping("/{userId}/followers/list")
    FollowerListDTO followers(@PathVariable int userId, @RequestParam(required = false) String order);

    @GetMapping("/{userId}/followed/list")
    FollowedListDTO followed(@PathVariable int userId, @RequestParam(required = false) String order);
}
