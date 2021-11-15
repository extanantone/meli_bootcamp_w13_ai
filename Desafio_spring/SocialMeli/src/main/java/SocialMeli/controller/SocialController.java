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

import javax.websocket.server.PathParam;

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

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<?> unfollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) {
        socialService.unfollowSeller(user_id, user_id_to_unfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getFollowersCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable int user_id, @PathParam("order") String order) {
        return new ResponseEntity<>(socialService.getFollowersList(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedListDTO> getFollowedList(@PathVariable int user_id, @PathParam("order") String order) {
        return new ResponseEntity<>(socialService.getFollowedList(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    ResponseEntity<?> follow(@RequestBody NewPostDTO post) {
        socialService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<PostListDTO> getPosts(@PathVariable int user_id, @PathParam("order") String order) {
        return new ResponseEntity<>(socialService.getTwoWeeksPost(user_id, order), HttpStatus.OK);
    }

}
