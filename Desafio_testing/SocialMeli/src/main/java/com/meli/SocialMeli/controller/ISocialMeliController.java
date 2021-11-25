package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/")
public interface ISocialMeliController {

    @PostMapping("users/{user_id}/follow/{user_id_tot_follow}")
    ResponseEntity<MensajeDTO> addFollow(@PathVariable("user_id") int userId, @PathVariable("user_id_tot_follow") int userIdFollow);

    @GetMapping("users/{user_id}/followers/count")
    ResponseEntity<CountDTO> countFollowers(@PathVariable("user_id") int userId);

    @GetMapping("users/{user_id}/followers/list")
    ResponseEntity<FollowersDTO> listFollowers(@PathVariable("user_id") int userId, @RequestParam(value = "order", required = false) String order);

    @GetMapping("users/{user_id}/followed/list")
    ResponseEntity<FollowedDTO> listFollowed(@PathVariable("user_id") int userId, @RequestParam(value = "order", required = false) String order);

    @PostMapping("products/post")
    ResponseEntity<MensajeDTO> addPost(@RequestBody @Valid PostDTOResponse post);

    @GetMapping("products/followed/{user_id}/list")
    ResponseEntity<ListPostsDTO> listPostFollowed(@PathVariable("user_id") int userId, @RequestParam(value = "order", required = false) String order);

    @PostMapping("users/{user_id}/unfollow/{user_id_to_unfollow}")
    ResponseEntity<MensajeDTO> unfollow(@PathVariable("user_id") int userId, @PathVariable("user_id_to_unfollow") int userIdFollow);

    @PostMapping("products/promo-post")
    ResponseEntity<MensajeDTO> addPromo(@RequestBody @Valid PromoDTO promo);

    @GetMapping("products/{user_id}/list")
    ResponseEntity<ListPromoDTO> listPromo(@PathVariable("user_id") int userId, @RequestParam(value = "order", required = false) String order);

    @GetMapping("products/{user_id}/promo-post/count")
    ResponseEntity<CountDTO> countPromo(@PathVariable("user_id") int userId);

}
