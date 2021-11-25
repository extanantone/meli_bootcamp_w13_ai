package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.CreatePostDTO;
import com.bootcamp.socialmeli.dto.CreatePostResponseDTO;
import com.bootcamp.socialmeli.dto.Ordenable;
import com.bootcamp.socialmeli.dto.PromoCountDTO;
import com.bootcamp.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<CreatePostResponseDTO> createPost(@RequestBody @Valid CreatePostDTO post){
        return ResponseEntity.ok(new CreatePostResponseDTO(postService.createPost(post)));
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<Ordenable> listFollowedPosts(@PathVariable("user_id") Long userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok(postService.listFollowedPosts(userId, order));
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PromoCountDTO> promoCountByUser(@PathVariable("user_id") Long userId){
        return ResponseEntity.ok(postService.promoCountByUser(userId));
    }

    @GetMapping("/{user_id}/promo-post/list")
    public ResponseEntity<Ordenable> listPromoPostsByUser(@PathVariable("user_id") Long userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok(postService.listPromoPostsByUser(userId, order));
    }
}
