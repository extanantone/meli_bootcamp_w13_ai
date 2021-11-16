package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.UserWithPostsDTO;
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
    public ResponseEntity<UserWithPostsDTO> getLast2WeeksFollowedPosts(@PathVariable long userId) {
        return new ResponseEntity<>(
                postService.getLatestFollowedPosts(userId, 2),
                HttpStatus.OK
        );
    }
}
