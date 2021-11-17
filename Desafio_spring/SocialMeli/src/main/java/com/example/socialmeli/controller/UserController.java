package com.example.socialmeli.controller;

import com.example.socialmeli.dto.FollowedDto;
import com.example.socialmeli.dto.FollowersDto;
import com.example.socialmeli.dto.ResponseDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{user_id}")
public class UserController {

    IUserService userServer;

    public UserController(IUserService userServer) {
        this.userServer = userServer;
    }


    @PostMapping("/follow/{user_id_to_follow}")
    public ResponseEntity<ResponseDto> follow(@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_follow") Integer userIdToFollow){

        if(userId.equals(userIdToFollow)) {
            throw new BadRequestException("Los id's no pueden ser identicos");
        }

        userServer.follower(userId,userIdToFollow);

        return new ResponseEntity<ResponseDto>(new ResponseDto("OK","Usuario seguido correctamente"), HttpStatus.OK);

    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowersDto> followersCount(@PathVariable("user_id") Integer userId)  {
        return new ResponseEntity<FollowersDto>(userServer.followersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/followers/list")
    public ResponseEntity<FollowersDto> followers(@PathVariable("user_id") Integer userId, @RequestParam(value = "order", defaultValue = "") String order) {
        System.out.println(order);
        return new ResponseEntity<FollowersDto>(userServer.followers(userId,order),HttpStatus.OK);
    }

    @GetMapping("/followed/list")
    public ResponseEntity<FollowedDto> followed(@PathVariable("user_id") Integer userId, @RequestParam(value = "order",defaultValue = "") String order) {
        return new ResponseEntity<FollowedDto>(userServer.followed(userId,order),HttpStatus.OK);
    }

    @PostMapping("/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<ResponseDto> unfollow(@PathVariable("user_id") Integer userId, @PathVariable("user_id_to_unfollow") Integer userIdToUnfollow) {
        if(userId.equals(userIdToUnfollow)) {
            throw new BadRequestException("Los id's no pueden ser identicos");
        }

        userServer.unfollow(userId,userIdToUnfollow);

        return new ResponseEntity<ResponseDto>(new ResponseDto("OK","Usuario unfollow correctamente"), HttpStatus.OK);
    }
}
