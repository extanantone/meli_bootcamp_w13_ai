package com.bootcamp.SocialMeli.controller;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.dto.product.*;
import com.bootcamp.SocialMeli.service.product.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> post(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productService.post(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<ProductFollowedListDTO> followedList(@PathVariable("user_id") int userId,
                                                               @RequestParam(defaultValue = "date_desc") String order) {
        return new ResponseEntity<>(productService.followedList(userId, order), HttpStatus.OK);
    }
}