package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.CompradorDTO;
import com.bootcamp.socialmeli.dto.MessageDTO;
import com.bootcamp.socialmeli.dto.UserCountDTO;
import com.bootcamp.socialmeli.dto.VendedorDTO;
import com.bootcamp.socialmeli.service.VendedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    VendedorService vendedorService;

    public UsersController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }


    // US0001
    @PostMapping("/{user_id}/follow/{user_id_to_follow}")
    public ResponseEntity<MessageDTO> postNewFollowToSeller(@PathVariable Long user_id, @PathVariable Long user_id_to_follow) {
        vendedorService.addFollower(user_id, user_id_to_follow);
        MessageDTO msg = new MessageDTO("Ok");
        return new ResponseEntity(msg, HttpStatus.OK);
    }

    // US0002
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserCountDTO> getFollerwsCount(@PathVariable Long user_id) {
        return new ResponseEntity(this.vendedorService.getFollowersCount(user_id), HttpStatus.OK);

    }

    // US0003
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<VendedorDTO> getSellerFollowers(@PathVariable Long user_id) {
        return new ResponseEntity(this.vendedorService.getFollowersList(user_id), HttpStatus.OK);

    }

    // US0004
    @GetMapping("/{user_id}/followed/list")
    public ResponseEntity<CompradorDTO> getBuyllerFollowers(@PathVariable Long user_id) {
        return new ResponseEntity(this.vendedorService.getFollowedsList(user_id), HttpStatus.OK);


    }


    // US0005




}
