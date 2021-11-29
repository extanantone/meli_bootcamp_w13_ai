package com.mercadolibre.socialmeli.controller;
import com.mercadolibre.socialmeli.dto.FollowDTO;
import com.mercadolibre.socialmeli.dto.FollowersCountDTO;
import com.mercadolibre.socialmeli.dto.FollowersDTO;
import com.mercadolibre.socialmeli.dto.UserDTO;
import com.mercadolibre.socialmeli.exception.FollowException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
//@Validated
public class UserController {
    final
    ISocialService socialService;

    public UserController(ISocialService socialService) {
        this.socialService = socialService;
    }
    //TODO modificar para que no quede la variable fea

    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<FollowDTO> followToUser(@Valid @PathVariable int user_id,
                                                  @Valid @PathVariable int user_id_to_follow) {
        FollowDTO follow = socialService.followToUser(new FollowDTO(user_id,user_id_to_follow));
        if(follow!=null) return new ResponseEntity<>(follow,HttpStatus.OK);
        return new ResponseEntity<>(follow,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{user_id}/followers/count")
    public FollowersCountDTO followerCount(@Valid @PathVariable int user_id) throws NotFoundException {
        return socialService.followersCount(user_id);
    }

    @GetMapping("/{user_id}/followers/list")
    public UserDTO allFollowers(@Valid @PathVariable int user_id){
        return socialService.allFollowers(user_id);
    }

    @GetMapping("/{user_id}/followed/list")
    public UserDTO allFollowed(@Valid @PathVariable int user_id) throws NotFoundException {
        return socialService.allFollowed(user_id);
    }

    @PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
    public Boolean unfollowUser(@Valid @PathVariable Integer user_id,
                                @Valid @PathVariable Integer user_id_to_unfollow){
        return socialService.unfollowUser(user_id,user_id_to_unfollow);
    }

    @GetMapping(value = "/{user_id}/followers/list",params = "order")
    public FollowersDTO sortUsersFollowers(@Valid @PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order){
        return socialService.orderingUsersFollowers(user_id,order);
    }

    @GetMapping(value = "{user_id}/followeds/list",params = "order")
    public FollowersDTO sortUsersFolloweds(@Valid @PathVariable Integer user_id, @RequestParam(defaultValue = "name_asc") String order){
        return socialService.orderingUsersFolloweds(user_id,order);
    }

}
