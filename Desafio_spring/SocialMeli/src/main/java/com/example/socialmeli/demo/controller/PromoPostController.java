package com.example.socialmeli.demo.controller;

import com.example.socialmeli.demo.dto.controllerToService.PublicacionDTO;
import com.example.socialmeli.demo.dto.controllerToService.PublicacionPromoDTO;
import com.example.socialmeli.demo.dto.controllerToService.RequestPostsFromFollowedsDTO;
import com.example.socialmeli.demo.dto.controllerToService.UserIdDTO;
import com.example.socialmeli.demo.dto.serviceToController.PostsFromMyFollowedUsersDTO;
import com.example.socialmeli.demo.dto.serviceToController.UserPromoPostListDTO;
import com.example.socialmeli.demo.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PromoPostController {

    @Autowired
    IPublicacionService iPublicacionService;

    @PostMapping("/products/newpromopost")
    public ResponseEntity createPost(@RequestBody PublicacionPromoDTO request){
        return iPublicacionService.createPromoPost(request);
    }

    @GetMapping("/products/{userId}/countPromo")
    public ResponseEntity getPromoPostsFromUserCount(@PathVariable int userId){

        UserIdDTO request = new UserIdDTO(userId);
        return iPublicacionService.countPromoPostOfUser(request);
    }

    @GetMapping("/products/{user_id}/list")
    public ResponseEntity<UserPromoPostListDTO> getPromoPostsListFromUserId(@PathVariable int user_id){

        UserIdDTO request = new UserIdDTO(user_id);

        return iPublicacionService.getPromoPostListOfUserId(request);

    }




}
