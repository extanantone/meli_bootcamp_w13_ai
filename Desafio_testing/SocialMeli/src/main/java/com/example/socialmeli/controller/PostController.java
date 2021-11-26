package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.PromoCountDTO;
import com.example.socialmeli.dto.PromoPostDTO;
import com.example.socialmeli.dto.UserPostDTO;
import com.example.socialmeli.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@Validated
public class PostController {
    IPostService postService;

    public PostController(IPostService postService) { this.postService = postService; }

    @PostMapping("/post")
    public ResponseEntity<?> postPost(@RequestBody @Valid PostDTO post) {
        postService.addPost(post.getUserId(), post.getIdPost(), post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<UserPostDTO> getPosts(@PathVariable(value = "user_id")Integer userId,
                                                @RequestParam(required = false) String order) {
        return new ResponseEntity<>(postService.getPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> postPromoPost(@RequestBody @Valid PromoPostDTO post) {
        postService.addPromoPost(post.getUserId(), post.getIdPost(), post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{user_id}/promo-post/count")
    public ResponseEntity<PromoCountDTO> getPromoCount(@PathVariable("user_id") Integer userId) {
        return new ResponseEntity<>(postService.getPromoCount(userId), HttpStatus.OK);
    }
}
