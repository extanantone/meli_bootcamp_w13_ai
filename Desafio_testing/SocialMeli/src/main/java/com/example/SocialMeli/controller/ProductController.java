package com.example.SocialMeli.controller;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.dto.VendedorDTO;
import com.example.SocialMeli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/post")
    public ResponseEntity<Boolean> postProduct(@Valid @RequestBody PostDTO postDTO) throws Exception {
        return ResponseEntity.ok(productService.saveProduct(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<VendedorDTO>> getSellersFollowed(@PathVariable int userId, @RequestParam(required = false) String order) throws Exception {
        return ResponseEntity.ok(this.productService.getSellerFollowed(userId, order));
    }

}
