package com.example.socialmeli.controller.v1.user;

import com.example.socialmeli.dto.FollowedListDTO;
import com.example.socialmeli.dto.FollowerCountDTO;
import com.example.socialmeli.dto.FollowerListDTO;
import com.example.socialmeli.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserController
{
    @Autowired
    IUserService userService;

    @Override
    public FollowedListDTO followed(int user_id)
    {
        return userService.followed(user_id);
    }

    @Override
    public FollowerListDTO followers(int user_id)
    {
        return userService.followers(user_id);
    }

    @Override
    public FollowerCountDTO countFollowers(int user_id)
    {
        return userService.countFollowers(user_id);
    }

    @Override
    public FollowerListDTO follow(int user_id, int user_id_to_follow)
    {
        return userService.follow(user_id, user_id_to_follow);
    }
}
