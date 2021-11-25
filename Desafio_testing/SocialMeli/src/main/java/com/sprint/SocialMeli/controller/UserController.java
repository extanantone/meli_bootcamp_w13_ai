package com.sprint.SocialMeli.controller;

import com.sprint.SocialMeli.dto.out.FollowedListDto;
import com.sprint.SocialMeli.dto.out.FollowersCountDto;
import com.sprint.SocialMeli.dto.out.FollowersListDto;
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

    // US0001
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public HttpStatus followSeller(@PathVariable int user_id, @PathVariable int user_id_to_follow) throws Exception {
        socialService.followSeller(user_id, user_id_to_follow);
        return HttpStatus.OK;
    }

    // US0002
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<FollowersCountDto> followersCount(@PathVariable int user_id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getSellerFollowersCount(user_id));
    }

    // US0003 + US0008
    // Para fusionar las US se aplico el RequestParam como no requerido, de forma que se puede llamar con o sin el order.
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<FollowersListDto> followersListSorted(@PathVariable int user_id, @RequestParam(value = "order", required=false) String order) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getSellerFollowersList(user_id, order));
    }

    // US0004 + US0008
    // Para fusionar las US se aplico el RequestParam como no requerido, de forma que se puede llamar con o sin el order.
    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<FollowedListDto> followedList(@PathVariable int user_id,@RequestParam(value = "order", required=false)  String order) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(socialService.getBuyerFollowedList(user_id, order));
    }

    // US0007
    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public HttpStatus unfollowSeller(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) throws Exception {
        socialService.unfollowSeller(user_id, user_id_to_unfollow);
        return HttpStatus.OK;
    }

}
