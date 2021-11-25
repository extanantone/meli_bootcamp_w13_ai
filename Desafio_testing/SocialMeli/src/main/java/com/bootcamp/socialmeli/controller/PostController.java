package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable long id) {
        return new ResponseEntity<>(
                postService.getPost(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(
                postService.createPost(postDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("followed/{userId}/list")
    public ResponseEntity<UserWithPostsDTO> getLast2WeeksFollowedPosts(@PathVariable long userId, @RequestParam(value = "order", required = false) String order) {
        UserWithPostsDTO resBody = postService.getLatestFollowedPosts(userId, 2);
        if (order != null) {
            order = order.replace("date_", "");
            resBody.setPosts(postService.orderPostsByDate(resBody.getPosts(), order));
        }
        return new ResponseEntity<>(
                resBody,
                HttpStatus.OK
        );
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostDTO> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        return new ResponseEntity<>(
                postService.createPromoPost(promoPostDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/promo-post/{id}")
    public ResponseEntity<PromoPostDTO> getPromoPost(@PathVariable long id) {
        return new ResponseEntity<>(
                postService.getPromoPost(id),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}/promo-post/count")
    public ResponseEntity<UserWithCountDTO> getUserWithPromoPostsCount(@PathVariable long id) {
        return new ResponseEntity<>(
                postService.getUserWithPromoPostCount(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}/promo-post/list")
    public ResponseEntity<UserWithPromoPostsDTO> getUserWithPromoPosts(@PathVariable long id) {
        return new ResponseEntity<>(
                postService.getUserWithPromoPosts(id),
                HttpStatus.OK
        );
    }
}
