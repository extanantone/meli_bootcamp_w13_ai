package com.example.socialmeli.demo.controller;

import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import com.example.socialmeli.demo.dto.controllerToService.DTOUserId;
import com.example.socialmeli.demo.dto.serviceToController.DTOUserPromoPostList;
import com.example.socialmeli.demo.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PromoPostController {

    @Autowired
    IPublicacionService iPublicacionService;

    //US 0010: crear una nueva publicacion con promocion
    @PostMapping("/products/newpromopost")
    public ResponseEntity createPost(@RequestBody DTOPromoPost request){
        return iPublicacionService.createPromoPost(request);
    }

    //US 0011: contar publicaciones en promocion de un determinado usuario
    @GetMapping("/products/{userId}/countPromo")
    public ResponseEntity getPromoPostsFromUserCount(@PathVariable int userId){

        DTOUserId request = new DTOUserId(userId);
        return iPublicacionService.countPromoPostOfUser(request);
    }

    //US 0012: obtener listado de publicaciones con promocion de un determinado usuario
    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<DTOUserPromoPostList> getPromoPostsListFromUserId(@PathVariable int user_id){

        DTOUserId request = new DTOUserId(user_id);
        return iPublicacionService.getPromoPostListOfUserId(request);
    }




}
