package com.example.socialmeli.controller;

import com.example.socialmeli.dto.NewPostRequestDto;
import com.example.socialmeli.dto.PostRequestResponseDto;
import com.example.socialmeli.dto.PostResponseDto;
import com.example.socialmeli.dto.UserResponseDto;
import com.example.socialmeli.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/product/post")
    public ResponseEntity<PostRequestResponseDto> addPost(@RequestBody NewPostRequestDto post){
        PostRequestResponseDto response = postService.addPost(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/product/promo-post")
    public ResponseEntity<PostRequestResponseDto> addPromoPost(@RequestBody NewPostRequestDto post){
        PostRequestResponseDto response = postService.addPost(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<PostResponseDto> getPostFromUserFollows(@PathVariable Integer user_id, @RequestParam(name="order",required = false) String order) {
        PostResponseDto response = postService.getPostFromUserId(user_id,order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<UserResponseDto> getPromoPostCountFromUser(@PathVariable Integer user_id){
        UserResponseDto response = postService.countPostFromUserId(user_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/promo-post")
    public ResponseEntity<PostResponseDto> getPromoPostFromUser(@PathVariable Integer user_id){
        PostResponseDto response = postService.getPromoPostFromUserId(user_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
