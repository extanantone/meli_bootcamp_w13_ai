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
    public FollowedListDTO followed(int userId, String order)
    {
        return userService.followed(userId, order);
    }

    @Override
    public FollowerListDTO followers(int userId, String order)
    {
        return userService.followers(userId, order);
    }

    @Override
    public FollowerCountDTO countFollowers(int userId)
    {
        return userService.countFollowers(userId);
    }

    @Override
    public FollowerListDTO follow(int userId, int userIdToFollow)
    {
        return userService.follow(userId, userIdToFollow);
    }

    @Override
    public FollowerListDTO unfollow(int userId, int userIdToUnfollow)
    {
        return userService.unfollow(userId, userIdToUnfollow);
    }
}
