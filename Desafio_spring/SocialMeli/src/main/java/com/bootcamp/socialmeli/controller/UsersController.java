package com.bootcamp.socialmeli.controller;

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
    public ResponseEntity<?> postNewFollowToSeller(@PathVariable Long user_id, @PathVariable Long user_id_to_follow) {
        return new ResponseEntity<>(
                vendedorService.getInfoSeller(user_id),
                HttpStatus.OK
        );
    }

    // US0001
    @GetMapping("/{user_id}/followers/count")
    public ResponseEntity<UserCountDTO> getSellerFollowersCount(@PathVariable Long user_id) {
        return new ResponseEntity<>(
                vendedorService.getInfoSeller(user_id),
                HttpStatus.OK
        );

    }

    // US0003
    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<VendedorDTO> getSellerFollowers(@PathVariable Long user_id) {
        return new ResponseEntity<>(
                vendedorService.getInfoSeller(user_id),
                HttpStatus.OK
        );

    }


}
