package com.example.socialmeli.controller.v1.user;

import com.example.socialmeli.dto.FollowedListDTO;
import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/users")
public interface IUserController
{
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    FollowerListDTO follow(@PathVariable int user_id, @PathVariable int user_id_to_follow);

    @GetMapping("/{user_id}/followers/count")
    FollowerCountDTO countFollowers(@PathVariable int user_id);

    @GetMapping("/{user_id}/followers/list")
    FollowerListDTO followers(@PathVariable int user_id);

    @GetMapping("/{user_id}/followed/list")
    FollowedListDTO followed(@PathVariable int user_id);
}
