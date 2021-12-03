package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.dto.PostDoneDTO;

import com.bootcamp.SocialMeli.model.*;
import com.bootcamp.SocialMeli.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//  US 0005

    @PostMapping("/products/post")
    public void postNewProduct(@RequestBody PostDTO newPost) throws ParseException {
        productService.post(newPost);
    }
    //prueba
    @GetMapping("/products")
    public List<Post> posts(){
        return productService.getPostList();
    }

// US 0009
    @GetMapping("/products/followed/{userId}/list")
    public PostDoneDTO postListLast2Weeks
    (@PathVariable Integer userId,@RequestParam(defaultValue = "date_desc") String order) {

        return productService.getPostListFrom2WeeksAgo(userId,order);
    }

}
