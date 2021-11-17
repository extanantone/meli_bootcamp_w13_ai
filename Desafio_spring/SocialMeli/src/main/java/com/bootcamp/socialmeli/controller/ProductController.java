package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.PostDTO;
import com.bootcamp.socialmeli.dto.RequestPostDTO;
import com.bootcamp.socialmeli.dto.ResponsePostDTO;
import com.bootcamp.socialmeli.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping("/post")
    public ResponseEntity postProduct(@RequestBody RequestPostDTO postDTO){
        iProductService.postProduct(postDTO);
        return ResponseEntity.ok().body(postDTO);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity getProductsFollowed(@PathVariable("user_id") int userId,
                                              @RequestParam(required = false) String order){
        ResponsePostDTO responsePostDTO = iProductService.getProductsFollowed(userId, order);

        return ResponseEntity.ok().body(responsePostDTO);
    }
}
