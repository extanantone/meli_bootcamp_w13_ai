package com.MeLi.SocialMeli.controller;

import com.MeLi.SocialMeli.DTO.SeguidoresDTO;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.service.VendedorServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendedorController {

    private VendedorServiceImplement vendedorServiceImplement;

    public VendedorController(VendedorServiceImplement vendedorServiceImplement){
        this.vendedorServiceImplement = vendedorServiceImplement;
    }

    @GetMapping("/users/{user_id}/followers/count")
    public ResponseEntity<SeguidoresDTO> getCantSeguidores(@PathVariable int user_id) throws NotFoundVendedorException {
        return new ResponseEntity<>(vendedorServiceImplement.contarSeguidores(user_id), HttpStatus.OK);
    }
}
