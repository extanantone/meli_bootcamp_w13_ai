package com.example.socialmeli.demo.controller;

import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestPostsFromFolloweds;
import com.example.socialmeli.demo.dto.serviceToController.DTOPostsFromMyFollowedUsers;
import com.example.socialmeli.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    IPostService iPostService;


    //US 0005: crear una nueva publicacion
    @PostMapping("/products/post")
    public ResponseEntity createPost(@RequestBody DTOPost request){
        return iPostService.createPost(request);
    }

    //US 0006: obtener las publicaciones posteriores a las 2 semanas anteriores a la fecha de hoy y US 0009
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<DTOPostsFromMyFollowedUsers> getPostsFromUserFollowersSinceTwoWeeks(@PathVariable int userId,
                                                                                              @RequestParam(value = "order", required = false) String order){

        DTORequestPostsFromFolloweds request = new DTORequestPostsFromFolloweds();
        request.setUserId(userId);
        request.setOrder(order);

        return iPostService.getPostsFromFollowedUsersSinceTwoWeeks(request);

    }




}
