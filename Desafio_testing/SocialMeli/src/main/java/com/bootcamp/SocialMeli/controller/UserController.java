package com.bootcamp.SocialMeli.controller;
import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {


    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<?> follow(@PathVariable int user_id, @PathVariable int user_id_to_follow){
        return new ResponseEntity<>(userService.follow(user_id,user_id_to_follow), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<?> count(@PathVariable int user_id)  {
        return new ResponseEntity<>(userService.count(user_id), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ResponseEntity<?> followers(@PathVariable int user_id, @RequestParam(required = false) String order)  {
        return new ResponseEntity<>(userService.followers(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}/followed/list")
    public ResponseEntity<?> followed(@PathVariable int user_id, @RequestParam(required = false) String order)  {
        return new ResponseEntity<>(userService.followed(user_id, order), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> post(@RequestBody PostDTO post)  {
        return new ResponseEntity<>(userService.newPost(post), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<?> followedSellersPost(@PathVariable("user_id") int user_id, @RequestParam(required = false) String order){

        return new ResponseEntity<>(userService.followedSellersPost(user_id, order),HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public ResponseEntity<?> unFollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow){
        return new ResponseEntity<>(userService.unFollow(user_id, user_id_to_unfollow), HttpStatus.OK);
    }













}
