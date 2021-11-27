package com.socialmeli.socialmeli.controller;

import com.socialmeli.socialmeli.dto.ResponseSuccessfullyDTO;
import com.socialmeli.socialmeli.dto.post.PostDTO;
import com.socialmeli.socialmeli.service.UserAndPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class PostController {
    @Autowired
    UserAndPostService userAndPostService;
    @Autowired
    ResponseSuccessfullyDTO responseSuccessfullyDTO;

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@Valid @RequestBody PostDTO postDTO){
        return new ResponseEntity(userAndPostService.newPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    ResponseEntity<?> followedSellersPost(@PathVariable("userId") int user_id,@RequestParam(required = false) String order){

        return new ResponseEntity(userAndPostService.followedSellersPost(user_id,order),HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> newPostWithDiscount(@RequestBody PostDTO postDTO){
        return new ResponseEntity(userAndPostService.newPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/{userId}/promo-post/count")
    ResponseEntity<?> followedSellersPost(@PathVariable("userId") int user_id){
        return new ResponseEntity(userAndPostService.countPromoPost(user_id),HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    ResponseEntity<?> ListPromoPost(@PathVariable("userId") int user_id){

        return new ResponseEntity(userAndPostService.ListPromoPost(user_id),HttpStatus.OK);
    }


}
