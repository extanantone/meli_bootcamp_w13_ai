package com.Sprint1.SocialMeli.controller;

import com.Sprint1.SocialMeli.model.Post;
import com.Sprint1.SocialMeli.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/socialMeli/product")
public class ProductController {
        IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


//================               US 0005            ================================
//      Dar de alta una nueva publicación
    @PostMapping("/post")
    public ResponseEntity<?> createPost (
            @RequestBody Post post){
        this.productService.createPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//================               US 0006            ================================
//   Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<?> postListFollowed (
            @PathVariable int user_id,
            @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<>(this.productService.postListFollowed(user_id, order), HttpStatus.OK);
    }
}
