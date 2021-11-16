package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.RequestPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping("/post")
    public ResponseEntity postProduct(@RequestBody RequestPostDTO postDTO){
        return ResponseEntity.ok().body(postDTO);
    }
}
