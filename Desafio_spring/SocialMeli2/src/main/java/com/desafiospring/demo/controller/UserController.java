package com.desafiospring.demo.controller;

import com.desafiospring.demo.DTO.UserSellerFollowersCountDTO;
import com.desafiospring.demo.service.FollowService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //asi aclaro que todos estos endpoint comienzan con /users/
public class UserController {
    FollowService followService;
//constructor
    public UserController(FollowService followService) {
        this.followService = followService;
    }

    //US 1- Poder realizar la accion que un usuario siga a un vendedor

    @PostMapping("/{userId}/folow/{idToFollow}")
    ResponseEntity<?> follow (@PathVariable("userId") Integer userId,
                              @PathVariable Integer idToFollow){

            followService.FollowSeller(userId, idToFollow);
            return new ResponseEntity<> (HttpStatus.OK);
    }

    //US2-
    //Realizamos un endpoint que nos dira que la cantidad de usuarios que siguen a los vendedores.
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserSellerFollowersCountDTO> getFollowersCount (@PathVariable("userId") Integer userId){

        UserSellerFollowersCountDTO sellerDTO = this.followService.countFollowers(userId);

        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }

    //US7- Poder realizar la accion de "Unfollow" a un determinado vendendor

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unFollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
       followService.unFollowers(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
