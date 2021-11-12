package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.exception.handler.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PublicacionController {

/*
    @PostMapping("/post")
    public ResponseEntity realizarPublicacion(
            throws BadRequestException {
        try {

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
