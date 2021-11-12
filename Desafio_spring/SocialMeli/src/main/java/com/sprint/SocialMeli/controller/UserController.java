package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.FollowedListDto;
import com.sprint.SocialMeli.dto.FollowersCountDto;
import com.sprint.SocialMeli.dto.FollowersListDto;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrontTypeException;
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
    public HttpStatus followSeller(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws WrontTypeException, NotFoundException {
        socialService.followVendedor(user_id, user_id_to_follow);
        return HttpStatus.OK;
    }

    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowersCountDto> followersCount(@PathVariable int user_id) throws WrontTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getSellerFollowersCount(user_id));
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowersListDto> followersList(@PathVariable int user_id) throws WrontTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getSellerFollowersList(user_id));
    }

    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListDto> followedList(@PathVariable int user_id) throws WrontTypeException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getBuyerFollowedList(user_id));
    }

}
