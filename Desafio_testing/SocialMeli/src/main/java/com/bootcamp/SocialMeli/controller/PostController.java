package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/products")
public class PostController {
    @Autowired
    IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<PostDTO> setpost(@RequestBody @Valid PostDTO postDTO ){
        return new ResponseEntity<>(iPostService.setPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<PublicacionesDTO> getListPostOrder(@PathVariable int user_id, @RequestParam(required = false) String order){
        if(order == null) return new ResponseEntity<>(iPostService.getPublicaciones(user_id),HttpStatus.OK);
        else return new ResponseEntity<>(iPostService.getPublicaciones(user_id, order),HttpStatus.OK);
    }

    @PostMapping("/promopost")
    public ResponseEntity<PromopostDTO> setPromoPost(@RequestBody @Valid PromopostDTO promopostDTO){
        return new ResponseEntity<>(iPostService.setPromopost(promopostDTO),HttpStatus.OK);
    }

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PromoPostCoutDTO> getPublicacionespromoCount(@PathVariable int user_id){
        return new ResponseEntity<>(iPostService.getCountPromo(user_id),HttpStatus.OK);
    }

    @GetMapping("/{user_id}/list")
    public ResponseEntity<PublicacionesPromoDTO> getPublicacionesPromo(@PathVariable int user_id){
        return  new ResponseEntity<>(iPostService.getpublicacionesPromo(user_id),HttpStatus.OK);
    }

}
