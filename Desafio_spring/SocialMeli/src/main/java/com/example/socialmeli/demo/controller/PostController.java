package com.example.socialmeli.demo.controller;

import com.example.socialmeli.demo.dto.controllerToService.DTOPost;
import com.example.socialmeli.demo.dto.controllerToService.DTORequestPostsFromFolloweds;
import com.example.socialmeli.demo.dto.serviceToController.DTOPostsFromMyFollowedUsers;
import com.example.socialmeli.demo.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    IPublicacionService iPublicacionService;


    //US 0005: crear una nueva publicacion
    @PostMapping("/products/post")
    public ResponseEntity createPost(@RequestBody DTOPost request){
        return iPublicacionService.createPost(request);
    }

    //US 0006: crear una nueva publicacion y US 0009
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<DTOPostsFromMyFollowedUsers> getPostsFromUserFollowersSinceTwoWeeks(@PathVariable int userId,
                                                                                              @RequestParam(value = "order", required = false) String order){

        DTORequestPostsFromFolloweds request = new DTORequestPostsFromFolloweds();
        request.setUserId(userId);
        request.setOrder(order);

        return iPublicacionService.getPostsFromUserFollowersSinceTwoWeeks(request);

    }




}
