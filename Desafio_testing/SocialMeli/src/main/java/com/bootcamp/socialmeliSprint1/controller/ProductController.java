package com.bootcamp.socialmeliSprint1.controller;

import com.bootcamp.socialmeliSprint1.dto.request.PostInDTO;
import com.bootcamp.socialmeliSprint1.dto.request.PostInPromoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.ProductsPromoInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.SellerProductsInPromoListDTO;
import com.bootcamp.socialmeliSprint1.dto.response.post.SellersPostsDTO;
import com.bootcamp.socialmeliSprint1.service.IProductService;
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

    @GetMapping(path = "/{user_id}/promo-post/count")
    public ResponseEntity<ProductsPromoInfoDTO> getNumberProductsInPromo(@PathVariable Integer user_id){
        return ResponseEntity.ok(productService.getNumberOfProductsInPromo(user_id));
    }

    @GetMapping(path = "/{user_id}/list")
    public ResponseEntity<SellerProductsInPromoListDTO> getListProductsInPromo(@PathVariable Integer user_id){
        return ResponseEntity.ok(productService.getProductsInPromo(user_id));
    }

}
