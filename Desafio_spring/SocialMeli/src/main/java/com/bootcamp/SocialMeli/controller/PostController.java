package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.FollowedPostsDTO;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsCountDTO;
import com.bootcamp.SocialMeli.dto.PromoPostsDTO;
import com.bootcamp.SocialMeli.mapper.IPostMapper;
import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController implements IPostController {

    /* TODO: add input validation */

    @Autowired IPostMapper postMapper;
    @Autowired IPostService postService;

    @PostMapping("products/post")
    public ResponseEntity<Void> create(@RequestBody PostDTO postDTO) {
        Post post = postMapper.postDTOToPost(postDTO);
        postService.addPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("products/promo-post")
    public ResponseEntity<Void> createWithPromo(@RequestBody PostDTO postDTO) {
        Post post = postMapper.postDTOToPost(postDTO);
        postService.addPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<FollowedPostsDTO> getFollowedPosts(@PathVariable int user_id, @RequestParam Optional<String> order) {
        FollowedPostsDTO followedPosts = postService.getFollowedPosts(user_id, order);
        return new ResponseEntity<>(followedPosts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PromoPostsCountDTO> getPromoPostsCount(int user_id, Optional<String> order) {
        PromoPostsCountDTO promoPostsCount = postService.getPromoPostsCount(user_id, order);
        return new ResponseEntity<>(promoPostsCount, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PromoPostsDTO> getPromoPosts(int user_id, Optional<String> order) {
        PromoPostsDTO promoPosts = postService.getPromoPosts(user_id, order);
        return new ResponseEntity<>(promoPosts, HttpStatus.OK);
    }
}
