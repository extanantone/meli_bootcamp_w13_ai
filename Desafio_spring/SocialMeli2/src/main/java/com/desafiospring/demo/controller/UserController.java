package com.desafiospring.demo.controller;

import com.desafiospring.demo.DTO.UserSellerFollowersCountDTO;
import com.desafiospring.demo.service.FollowService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    FollowService followService;

    public UserController(FollowService followService) {
        this.followService = followService;
    }
    //US 1- Poder realizar la accion que un usuario siga a un vendedor
    @PostMapping("/users/{userId}/folow/{idToFollow}")
    ResponseEntity<?> follow (@PathVariable("userId") Integer userId,
                              @PathVariable Integer idToFollow){

            followService.FollowSeller(userId, idToFollow);
            return new ResponseEntity<> (HttpStatus.OK);
    }

    //US2- obtener la cantidad de usuarios que siguen a un determinado vendedor

    @GetMapping("/users/{userId}/followers/count")
    ResponseEntity<UserSellerFollowersCountDTO> getFollowersCount (@PathVariable("userId") Integer userID){

    }

}
