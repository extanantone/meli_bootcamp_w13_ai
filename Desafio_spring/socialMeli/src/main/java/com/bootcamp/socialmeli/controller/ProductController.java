package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.request.post.PostInDTO;
import com.bootcamp.socialmeli.dto.response.post.SellersPostsDTO;
import com.bootcamp.socialmeli.service.IProductService;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/followed/{user_id}/list")
    public ResponseEntity<SellersPostsDTO> getSellersPosts(@PathVariable Integer user_id){
        return ResponseEntity.ok(productService.getSellersPosts(user_id));
    }

//    /products/followed/{user_id}/list

}
