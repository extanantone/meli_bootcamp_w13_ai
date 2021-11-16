package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.PublicationDTO;
import com.bootcamp.SocialMeli.exception.BadRequest;
import com.bootcamp.SocialMeli.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {
    ISocialMeliService isocialMeliService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<?> follow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow) throws BadRequest {
        try {
            isocialMeliService.addNewFollow(user_id, user_id_to_follow);
        } catch (RuntimeException e) {
            throw new BadRequest(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<CountDTO> followersCount(@PathVariable Integer user_id) throws BadRequest {
        try {
            isocialMeliService.followerCount(user_id);
        } catch (RuntimeException e) {
            throw new BadRequest(e.getMessage());
        }
        return new ResponseEntity<>(isocialMeliService.followerCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowerDTO> followerList(@PathVariable Integer user_id) throws BadRequest {
        FollowerDTO followerDTO;
        try {
            followerDTO = isocialMeliService.followerList(user_id);
        } catch (RuntimeException e) {
            throw new BadRequest(e.getMessage());
        }
        return new ResponseEntity<>(followerDTO, HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedDTO> followedList(@PathVariable Integer user_id) throws BadRequest {
        FollowedDTO followedDTO;
        try {
            followedDTO = isocialMeliService.followedList(user_id);
        } catch (RuntimeException e) {
            throw new BadRequest(e.getMessage());
        }
        return new ResponseEntity<>(followedDTO, HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity publication(@RequestBody PublicationDTO publicationDTO) throws BadRequest{
        try{isocialMeliService.newPublication(publicationDTO);
        } catch (RuntimeException e){
            throw  new BadRequest(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<?> unfollow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_unfollow) throws BadRequest {
        try {
            isocialMeliService.deleteFollow(user_id, user_id_to_unfollow);
        } catch (RuntimeException e) {
            throw new BadRequest(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}