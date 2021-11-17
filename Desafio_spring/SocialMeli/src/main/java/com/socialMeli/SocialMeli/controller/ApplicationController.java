package com.socialMeli.SocialMeli.controller;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.service.PostService;
import com.socialMeli.SocialMeli.userDto.ResponseDTO;
import com.socialMeli.SocialMeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(userService.verifyUsers(user_id,user_id_to_follow)){
            return new ResponseEntity<Optional>(Optional.of(userService.follow(user_id, user_id_to_follow)), HttpStatus.OK);
        }else{
            ResponseDTO response = new ResponseDTO("Uno de los usuarios no existe");
            return new ResponseEntity<Optional>(Optional.of(response), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<Optional> followersCount(@PathVariable Integer user_id){
        if(userService.verifyUsers(user_id)){
            return new ResponseEntity<Optional>(Optional.of(userService.countFollowers(user_id)), HttpStatus.OK);
        }else{
            ResponseDTO response = new ResponseDTO("El usuario no existe");
            return new ResponseEntity<Optional>(Optional.of(response), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<Optional> followersList(@PathVariable Integer user_id, @RequestParam(required = false) String order ){
        if(userService.verifyUsers(user_id)){
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
        }else{
            ResponseDTO response = new ResponseDTO("El usuario no existe");
            return new ResponseEntity<Optional>(Optional.of(response), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<Optional> followedList(@PathVariable Integer user_id, @RequestParam(required = false) String order ){
        if(userService.verifyUsers(user_id)){
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
        }else{
            ResponseDTO response = new ResponseDTO("El usuario no existe");
            return new ResponseEntity<Optional>(Optional.of(response), HttpStatus.OK);
        }
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_follow}")
    public ResponseEntity<Optional> unfollow(@PathVariable Integer user_id, @PathVariable Integer user_id_to_follow){
        if(userService.verifyUsers(user_id,user_id_to_follow)){
            return new ResponseEntity<Optional>(Optional.of(userService.unfollow(user_id, user_id_to_follow)), HttpStatus.OK);
        }else{
            ResponseDTO response = new ResponseDTO("Uno de los usuarios no existe");
            return new ResponseEntity<Optional>(Optional.of(response), HttpStatus.BAD_REQUEST);
        }
    }

    /*--------------------------------POST CONTROLLER-------------------------------------*/

    @PostMapping("/products/post")
    public ResponseEntity<Optional> createPost(@RequestBody Post post){
        return new ResponseEntity<Optional>(Optional.of(postService.create(post)), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<Optional> productListFollowed(@PathVariable Integer user_id, @RequestParam(required = false) String order){
        if(order==null){
            return new ResponseEntity<Optional>(Optional.of(postService.productListFollowed(userService.getUserRepository().getList_users().get(user_id))),HttpStatus.OK);
        }else{
            if(order.equals("date_desc")){
                return new ResponseEntity<Optional>(Optional.of(postService.productListFollowed(userService.getUserRepository().getList_users().get(user_id),"date_desc")),HttpStatus.OK);
            }else{
                return new ResponseEntity<Optional>(Optional.of(postService.productListFollowed(userService.getUserRepository().getList_users().get(user_id))),HttpStatus.OK);
            }
        }
    }


}
