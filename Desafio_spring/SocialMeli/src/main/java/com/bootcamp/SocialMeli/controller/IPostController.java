package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface IPostController {
    @PostMapping("products/post")
    ResponseEntity<Void> create(@RequestBody PostDTO postDTO);

    @GetMapping("/products/followed/{user_id}/list")
    ResponseEntity<FollowedPostsDTO> getFollowedPosts(@PathVariable int user_id, @RequestParam Optional<String> order);
}
