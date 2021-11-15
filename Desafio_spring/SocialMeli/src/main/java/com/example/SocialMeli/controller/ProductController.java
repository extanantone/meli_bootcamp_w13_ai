package com.example.SocialMeli.controller;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/post")
    public ResponseEntity<Boolean> postProduct(@RequestBody PostDTO postDTO) throws Exception {
        return ResponseEntity.ok(productService.saveProduct(postDTO));
    }

}
