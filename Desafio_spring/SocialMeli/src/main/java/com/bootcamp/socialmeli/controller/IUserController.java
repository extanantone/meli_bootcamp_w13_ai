package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.UserFollowedDTO;
import com.bootcamp.socialmeli.dto.UserFollowersDTO;
import com.bootcamp.socialmeli.dto.UserListDTO;
import com.bootcamp.socialmeli.dto.UserTotalFollowersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {
    //US 0001
    void followUser(int userId, int userIdToFollow);
    //US 0002
    ResponseEntity getTotalUserFollowers(int userId);
    //US 0003
    ResponseEntity getUserFollowers(int userId);
    //US 0008
    //ResponseEntity getUserFollowers(int userId, String order);
    //US 0004
    ResponseEntity getUserFollowed(int userId);
    //US 0097
    void unfollowUser(int userId, int userIdToUnfollow);

}
