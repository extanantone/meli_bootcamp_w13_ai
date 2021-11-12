package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.FollowedListDto;
import com.sprint.SocialMeli.dto.FollowersCountDto;
import com.sprint.SocialMeli.dto.FollowersListDto;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;
import com.sprint.SocialMeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    ISocialService socialService;
    public UserController(ISocialService socialService){
        this.socialService = socialService;
    }

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public HttpStatus followSeller(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws WrongTypeException, NotFoundException {
        socialService.followSeller(user_id, user_id_to_follow);
        return HttpStatus.OK;
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowersCountDto> followersCount(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getSellerFollowersCount(user_id));
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowersListDto> followersList(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getSellerFollowersList(user_id));
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListDto> followedList(@PathVariable int user_id) throws WrongTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getBuyerFollowedList(user_id));
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public HttpStatus unfollowSeller(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws WrongTypeException, NotFoundException {
        socialService.unfollowSeller(user_id, user_id_to_unfollow);
        return HttpStatus.OK;
    }

}
