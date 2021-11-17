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
//TODO agregar orden data
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

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostResponseDto> getPostFromUserFollows(@PathVariable Integer userId, @RequestParam(name="order",required = true) String order) {
        PostResponseDto response = postService.getPostFromUserId(userId,order);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/promo-post/count")
    public ResponseEntity<UserResponseDto> getPromoPostCountFromUser(@PathVariable Integer userId){
        UserResponseDto response = postService.countPostFromUserId(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/promo-post")
    public ResponseEntity<PostResponseDto> getPromoPostFromUser(@PathVariable Integer userId){
        PostResponseDto response = postService.getPromoPostFromUserId(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
