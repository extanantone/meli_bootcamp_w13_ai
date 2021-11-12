package com.socialmeli.controller;

import com.socialmeli.dto.SellerFollowersCountDto;
import com.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private IUserService iUserService;

    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @PostMapping("/users/{userId}/follow/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public void follow(@PathVariable int userId,@PathVariable int sellerId){
        iUserService.followUser(userId,sellerId);
    }

    @GetMapping("/users/{userId}/followers/count")
    public SellerFollowersCountDto getCountSeller(@PathVariable int userId){
        return iUserService.getCountBySeller(userId);
    }

}
