package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.repository.IPostRepository;
import com.example.socialmeli.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    IPostService postService;

    public PostController(IPostService postService) { this.postService = postService; }

    @PostMapping("/products/post")
    public ResponseEntity<?> postPost(@RequestBody PostDTO post) {
        postService.addPost(post.getUserId(), post.getIdPost(), post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
