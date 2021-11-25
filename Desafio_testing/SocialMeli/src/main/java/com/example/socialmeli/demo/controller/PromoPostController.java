package com.example.socialmeli.demo.controller;

import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserPromoPostList;
import com.example.socialmeli.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PromoPostController {

    @Autowired
    IPostService iPostService;

    //US 0010: crear una nueva publicacion con promocion
    @PostMapping("/products/promo-post")
    public ResponseEntity createPost(@RequestBody DTOPromoPost request){
        return iPostService.createPromoPost(request);
    }

    //US 0011: contar publicaciones en promocion de un determinado usuario
    @GetMapping("/products/{userId}/promo-post/count")
    public ResponseEntity getPromoPostsFromUserCount(@PathVariable int userId){

        DTOUserId request = new DTOUserId(userId);
        return iPostService.countPromoPostOfUser(request);
    }

    //US 0012: obtener listado de publicaciones con promocion de un determinado usuario
    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<DTOUserPromoPostList> getPromoPostsListFromUserId(@PathVariable int user_id){

        DTOUserId request = new DTOUserId(user_id);
        return iPostService.getPromoPostListOfUserId(request);
    }




}
