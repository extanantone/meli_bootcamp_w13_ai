package com.socialmeli.controller;

import com.socialmeli.dto.FollowedListDto;
import com.socialmeli.dto.FollowerListDto;
import com.socialmeli.dto.PostDto;
import com.socialmeli.dto.SellerFollowersCountDto;
import com.socialmeli.service.IUserService;
import lombok.Getter;
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

    @GetMapping("/users/{userId}/followers/list")
    public FollowerListDto getFollower(@PathVariable int userId){
        return iUserService.getFollowerList(userId);
    }

    @GetMapping("/users/{userId}/followed/list")
    public FollowedListDto getFollowed(@PathVariable int userId){
        return  iUserService.getFollowed(userId);
    }

    @PostMapping("/products/post")
    public void addPost(@RequestBody PostDto dto){
        System.out.println(dto.getDate());
        iUserService.addPost(dto);
    }

}
