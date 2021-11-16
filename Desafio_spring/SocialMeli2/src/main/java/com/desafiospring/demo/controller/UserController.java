package com.desafiospring.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UserController {
    @PostMapping("/users/{userId}/folow/{idToFollow}")
    ResponseEntity<?> follow (@PathVariable("userId") Integer userId,
                              @PathVariable Integer idToFollow){
        return new ResponseEntity<> (HttpStatus.OK);
    }


}
