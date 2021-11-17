package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.PostDTORequest;
import com.SocialMeli.SocialMeli.dto.PostPromoDTORequest;
import com.SocialMeli.SocialMeli.dto.SellerCountPromosDTOResponse;
import com.SocialMeli.SocialMeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    IPostService postService;

    @PostMapping("/products/post")
    public ResponseEntity<?> create(@RequestBody PostDTORequest postDTORequest) {
        return new ResponseEntity<>(postService.create(postDTORequest), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<?> getByUserId(@PathVariable int user_id, @RequestParam(name="order",required = false) String order) {
        return new ResponseEntity<>(postService.getByUser(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> createPromo(@RequestBody PostPromoDTORequest postPromoDTORequest) {
        return new ResponseEntity<>(postService.createPromo(postPromoDTORequest), HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/promo-post/count")
    public ResponseEntity<?> getSellerPromosCount(@PathVariable int userId) {
        return new ResponseEntity<SellerCountPromosDTOResponse>(postService.getSellerPromosCount(userId), HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<?> getSellerPromos(@PathVariable int user_id){
        return new ResponseEntity<>(postService.getPromosByUser(user_id), HttpStatus.OK);
    }
}
