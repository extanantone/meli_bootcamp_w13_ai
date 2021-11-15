package com.example.socialmeli.demo.controller;

import com.example.socialmeli.demo.dto.controllerToService.PublicacionDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestPostsFromFollowedsDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.PostsFromMyFollowedUsersDTO;
import com.example.socialmeli.demo.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    IPublicacionService iPublicacionService;


    @PostMapping("/products/post")
    public ResponseEntity createPost(@RequestBody PublicacionDTO request){
        return iPublicacionService.createPost(request);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public ResponseEntity<PostsFromMyFollowedUsersDTO> getPostsFromUserFollowersSinceTwoWeeks(@RequestBody UserIdDTO userId,
                                                                                              @RequestParam(value = "order", required = false) String order){

        RequestPostsFromFollowedsDTO request = new RequestPostsFromFollowedsDTO();
        request.setUserId(userId.getUser_id());
        request.setOrder(order);

        return iPublicacionService.getPostsFromUserFollowersSinceTwoWeeks(request);

    }


}
