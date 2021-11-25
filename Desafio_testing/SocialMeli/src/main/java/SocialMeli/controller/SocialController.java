package SocialMeli.controller;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.request.NewUserDTO;
import SocialMeli.dto.response.list.FollowedListDTO;
import SocialMeli.dto.response.count.FollowersCountDTO;
import SocialMeli.dto.response.list.FollowersListDTO;
import SocialMeli.dto.response.list.PostListDTO;
import SocialMeli.dto.response.count.PromoCountDTO;
import SocialMeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
  Buenas! El readme se encuentra dentro de la carpeta Desafio_Sprint junto con el archivo
  de Postman por si además de los test es necesario probar algo.

 ACLARAR NOT NULL vs POSITIVE

*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   **/

@RestController
public class SocialController {
    ISocialService socialService;

    public SocialController(ISocialService socialService) {
        this.socialService = socialService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    ResponseEntity<?> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        socialService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        socialService.unfollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(socialService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    ResponseEntity<FollowedListDTO> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    ResponseEntity<?> newPost(@RequestBody @Valid NewPostDTO post) {
        socialService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    ResponseEntity<PostListDTO> getPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialService.getTwoWeeksPost(userId, order), HttpStatus.OK);
    }

    //BONUS

    @PostMapping("/products/promopost")
    ResponseEntity<?> newPromoPost(@RequestBody @Valid NewPostDTO post) {
        socialService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/promo-post/count")
    ResponseEntity<PromoCountDTO> getPromoPostCount(@PathVariable int userId) {
        return new ResponseEntity<>(socialService.getPromoCount(userId), HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/list")
    ResponseEntity<PostListDTO> newPost(@PathVariable int userId) {
        return new ResponseEntity<>(socialService.getPromoList(userId), HttpStatus.OK);
    }

    @PostMapping("/user/newUser")
    ResponseEntity<?> newUser(@RequestBody @Valid NewUserDTO user) {
        socialService.newUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
