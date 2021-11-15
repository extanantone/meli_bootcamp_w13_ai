package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.request.PublicacionDTO;
import com.bootcamp.SocialMeli.service.ISocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsSMController {

    @Autowired
    private ISocialMeliService socialMeliService;

    @PostMapping("/post")
    public ResponseEntity<?> crearPublicacion(@RequestBody PublicacionDTO post){
        return new ResponseEntity<>(this.socialMeliService.crearPublicacion(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<?> getPublicacionesSeguidos(@PathVariable("user_id") Integer userId){
        return new ResponseEntity<>(this.socialMeliService.getPublicacionesSeguidos(userId), HttpStatus.OK);
    }

}
