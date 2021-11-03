package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Probando {
    @GetMapping("/holaMundo")
    ResponseEntity<String> holaMundo(){
        return new ResponseEntity<>("Hola mundo!!!", HttpStatus.OK);
        //return ResponseEntity.ok("Hola mundo");
    }
}
