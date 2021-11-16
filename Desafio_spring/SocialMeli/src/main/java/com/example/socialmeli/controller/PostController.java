package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.UserPostDTO;
import com.example.socialmeli.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    IPostService postService;

    public PostController(IPostService postService) { this.postService = postService; }

    @PostMapping("/products/post")
    public ResponseEntity<?> postPost(@RequestBody PostDTO post) {
        postService.addPost(post.getUserId(), post.getIdPost(), post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<UserPostDTO> getPosts(@PathVariable(value = "user_id")Integer userId) {
        return new ResponseEntity<>(postService.getPosts(userId), HttpStatus.OK);
    }
}
