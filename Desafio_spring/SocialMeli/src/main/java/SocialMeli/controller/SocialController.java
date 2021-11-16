package SocialMeli.controller;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.response.list.FollowedListDTO;
import SocialMeli.dto.response.count.FollowersCountDTO;
import SocialMeli.dto.response.list.FollowersListDTO;
import SocialMeli.dto.response.list.PostListDTO;
import SocialMeli.dto.response.count.PromoCountDTO;
import SocialMeli.dto.response.list.PromoPostListDTO;
import SocialMeli.service.ISocialService;
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
    ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable int user_id, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialService.getFollowersList(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    ResponseEntity<FollowedListDTO> getFollowedList(@PathVariable int user_id, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialService.getFollowedList(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    ResponseEntity<?> newPost(@RequestBody NewPostDTO post) {
        socialService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<PostListDTO> getPosts(@PathVariable int user_id, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialService.getTwoWeeksPost(user_id, order), HttpStatus.OK);
    }

    //BONUS

    @PostMapping("/products/promopost")
    ResponseEntity<?> newPromoPost(@RequestBody NewPostDTO post) {
        socialService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/promo-post/count")
    ResponseEntity<PromoCountDTO> getPromoPostCount(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/list")
    ResponseEntity<PromoPostListDTO> newPost(@PathVariable int user_id) {
        return new ResponseEntity<>(socialService.getPromoList(user_id),HttpStatus.OK);
    }

}
