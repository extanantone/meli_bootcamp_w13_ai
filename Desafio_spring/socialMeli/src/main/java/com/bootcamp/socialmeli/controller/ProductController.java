package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.dto.request.PostInDTO;
import com.bootcamp.socialmeli.dto.request.PostInPromoDTO;
import com.bootcamp.socialmeli.dto.response.post.SellersPostsDTO;
import com.bootcamp.socialmeli.service.IProductService;
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
    public ResponseEntity<SellersPostsDTO> getSellersPosts(@PathVariable Integer user_id,
                                                           @RequestParam(defaultValue = "",required = false) String order){

        if(order.equals("")){
            return ResponseEntity.ok(productService.getSellersPosts(user_id));
        }else{
            return ResponseEntity.ok(productService.getSellersPostsSort(user_id,order));
        }

    }

    @PostMapping(path = "/promopost")
    public ResponseEntity<String> createPromoPost(@RequestBody PostInPromoDTO post){

        productService.createPostPromo(post);
        return ResponseEntity.ok("El post promocional con id:" + post.getIdPost()
                + " ha sido publicado por el vendedor con id:" + post.getUserId());
    }




}
