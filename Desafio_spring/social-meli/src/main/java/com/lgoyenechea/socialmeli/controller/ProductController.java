package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.PostCreationDTO;
import com.lgoyenechea.socialmeli.dto.PostDTO;
import com.lgoyenechea.socialmeli.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    ResponseEntity<PostDTO> newProductPost(@RequestBody PostCreationDTO newPost) {
        PostDTO post = productService.save(newPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
