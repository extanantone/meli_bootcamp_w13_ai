package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsCountDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface IPostController {
    @PostMapping("products/post")
    ResponseEntity<Void> create(@RequestBody PostDTO postDTO);

    @PostMapping("products/post")
    ResponseEntity<Void> createWithPromo(@RequestBody PostDTO postDTO);

    @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<FollowedPostsDTO> getFollowedPosts(@PathVariable int user_id, @RequestParam Optional<String> order);

    @GetMapping("/products/{user_id}/promo-post/count")
    ResponseEntity<PromoPostsCountDTO> getPromoPostsCount(@PathVariable int user_id, @RequestParam Optional<String> order);

    @GetMapping("/products/{user_id}/list")
    ResponseEntity<PromoPostsDTO> getPromoPosts(@PathVariable int user_id, @RequestParam Optional<String> order);
}
