package com.bootcamp.socialmeli.controller;


import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDTO> addNewPost(@RequestBody ReqProductDTO newPostReq) {
        this.postService.createNewPost(newPostReq);
        MessageDTO msg = new MessageDTO("Ok");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<UserPostDTO> getRecentPostsByFollowed(
            @PathVariable("user_id") Long idUser,
            @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity(postService.getRecientPost(idUser, order),
                HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> publishPromo(@RequestBody ReqPromotionDTO reqPromotionDTO) {
        postService.createPromo(reqPromotionDTO);
        MessageDTO msg = new MessageDTO("Ok");
        return new ResponseEntity(msg, HttpStatus.OK);
    }

    @GetMapping("{user_id}/promo-post/count")
    public ResponseEntity<UserPostDTO> getAllPromotionsOfUser(
            @PathVariable("user_id") Long idUser) {
        return new ResponseEntity(postService.getPromosCount(idUser), HttpStatus.OK);
    }

    @GetMapping("{user_id}/list")
    public ResponseEntity<UserPromoAllDTO> getAllPromotionsList(@PathVariable("user_id") Long idUser) {
        return new ResponseEntity(postService.getAllPromotionsList(idUser),
                HttpStatus.OK);
    }

}
