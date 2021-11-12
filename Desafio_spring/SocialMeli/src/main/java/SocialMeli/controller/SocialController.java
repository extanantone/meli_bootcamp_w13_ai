package SocialMeli.controller;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.response.FollowedListDTO;
import SocialMeli.dto.response.FollowersCountDTO;
import SocialMeli.dto.response.FollowersListDTO;
import SocialMeli.dto.response.PostListDTO;
import SocialMeli.service.ISocialService;
import SocialMeli.service.SocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialController {
    ISocialService socialService;

    public SocialController(ISocialService socialService) {
        this.socialService = socialService;
    }

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    ResponseEntity<?> follow(@PathVariable int user_id, @PathVariable int user_id_to_follow) {
        socialService.followSeller(user_id, user_id_to_follow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getFollowersCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getFollowersList(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedListDTO> getFollowedList(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getFollowedList(user_id), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    ResponseEntity<?> follow(@RequestBody NewPostDTO post) {
        socialService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

  /*  @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<PostListDTO> getPosts(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getFollowedList(user_id), HttpStatus.OK);
    } */

}
