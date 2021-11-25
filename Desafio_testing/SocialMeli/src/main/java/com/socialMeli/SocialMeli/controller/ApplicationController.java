package com.socialMeli.SocialMeli.controller;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.postDTO.PromoPostInDTO;
import com.socialMeli.SocialMeli.service.PostService;
import com.socialMeli.SocialMeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping
public class ApplicationController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<Optional> follow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow){
            return new ResponseEntity<Optional>(Optional.of(userService.follow(user_id, user_id_to_follow)), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<Optional> followersCount(@PathVariable Integer user_id){
            return new ResponseEntity<Optional>(Optional.of(userService.countFollowers(user_id)), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<Optional> followersList(@PathVariable Integer user_id, @RequestParam(required = false) String order ){
            if(order==null){
                return new ResponseEntity<Optional>(Optional.of(userService.listFollowers(user_id)), HttpStatus.OK);
            }else{
                switch (order){
                    case "name_asc":
                        return new ResponseEntity<Optional>(Optional.of(userService.listFollowers(user_id,"name_asc")), HttpStatus.OK);
                    case "name_desc":
                        return new ResponseEntity<Optional>(Optional.of(userService.listFollowers(user_id, "name_desc")), HttpStatus.OK);
                    default:
                        return new ResponseEntity<Optional>(Optional.of(userService.listFollowers(user_id)), HttpStatus.OK);
                }
            }
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<Optional> followedList(@PathVariable Integer user_id, @RequestParam(required = false) String order ){
            if(order==null){
                return new ResponseEntity<Optional>(Optional.of(userService.listFollowed(user_id)), HttpStatus.OK);
            }else{
                switch (order){
                    case "name_asc":
                        return new ResponseEntity<Optional>(Optional.of(userService.listFollowed(user_id,"name_asc")), HttpStatus.OK);
                    case "name_desc":
                        return new ResponseEntity<Optional>(Optional.of(userService.listFollowed(user_id, "name_desc")), HttpStatus.OK);
                    default:
                        return new ResponseEntity<Optional>(Optional.of(userService.listFollowed(user_id)), HttpStatus.OK);
                }
            }
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity<Optional> unfollow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow){
        return new ResponseEntity<Optional>(Optional.of(userService.unfollow(user_id, user_id_to_follow)), HttpStatus.OK);
    }

    /*--------------------------------POST CONTROLLER-------------------------------------*/

    @PostMapping("/products/post")
    public ResponseEntity<Optional> createPost(@Valid @RequestBody Post post){
        return new ResponseEntity<Optional>(Optional.of(postService.create(post,userService.getUserRepository().getList_users())), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<Optional> productListFollowed(@PathVariable Integer user_id, @RequestParam(required = false) String order){
        if(order==null){
            return new ResponseEntity<Optional>(Optional.of(postService.productListFollowed(userService.getUserRepository().getList_users(),user_id)),HttpStatus.OK);
        }else{
            if(order.equals("date_desc")){
                return new ResponseEntity<Optional>(Optional.of(postService.productListFollowed(userService.getUserRepository().getList_users(),user_id,"date_desc")),HttpStatus.OK);
            }else{
                return new ResponseEntity<Optional>(Optional.of(postService.productListFollowed(userService.getUserRepository().getList_users(),user_id)),HttpStatus.OK);
            }
        }
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<Optional> createPromoPost(@RequestBody PromoPostInDTO post){
        return new ResponseEntity<Optional>(Optional.of(postService.create(post,userService.getUserRepository().getList_users())), HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/promo-post/count")
    public ResponseEntity<Optional> promoProductsCount(@PathVariable Integer user_id){
        return new ResponseEntity<Optional>(Optional.of(postService.promoProductsCount(user_id,userService.getUserRepository().getList_users())), HttpStatus.OK);
    }

    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<Optional> promoProductsList(@PathVariable Integer user_id){
        return new ResponseEntity<Optional>(Optional.of(postService.promoProductsList(user_id,userService.getUserRepository().getList_users())), HttpStatus.OK);
    }

}
