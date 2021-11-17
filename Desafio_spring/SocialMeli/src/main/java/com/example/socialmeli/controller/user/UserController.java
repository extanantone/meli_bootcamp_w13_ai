package com.example.socialmeli.controller.user;

import com.example.socialmeli.dto.user.FollowedListDTO;
import com.example.socialmeli.dto.user.FollowerCountDTO;
import com.example.socialmeli.dto.user.FollowerListDTO;
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
    public FollowedListDTO follow(int userId, int userIdToFollow)
    {
        return userService.follow(userId, userIdToFollow);
    }

    @Override
    public FollowedListDTO unfollow(int userId, int userIdToUnfollow)
    {
        return userService.unfollow(userId, userIdToUnfollow);
    }
}
