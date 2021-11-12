package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.VendedorDTO;
import com.bootcamp.socialmeli.service.VendedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    VendedorService vendedorService;

    public UsersController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping("/{user_id}/followers/list")
    public ResponseEntity<VendedorDTO> getSellerFollowers(@PathVariable Long user_id) {
        return new ResponseEntity<>(
                vendedorService.getInfoSeller(user_id),
                HttpStatus.OK
        );

    }
}
