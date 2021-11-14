package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.request.post.PostInDTO;
import com.bootcamp.socialmeli.service.IProductService;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/post")
    public ResponseEntity<String> createPost(@RequestBody PostInDTO post){

        productService.createPost(post);
        return ResponseEntity.ok("El post con id:" + post.getIdPost()
                + " ha sido publicado por el vendedor con id:" + post.getUserId());
    } 
}
