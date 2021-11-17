package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.dto.ResponseDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.server.IProductServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    IProductServer productServer;

    public PostController(IProductServer productServer) {
        this.productServer = productServer;
    }

    @PostMapping(value= {"/post", "/promo-post"})
    public ResponseEntity<ResponseDto> createPost(@RequestBody Post post) {

        if(post.getDiscount() == null && post.getHasPromo()) {
            throw new BadRequestException("Ingresa un descuento a la promo");
        }

        productServer.createPost(post);

        return new ResponseEntity<ResponseDto>(new ResponseDto("OK","Publicacion creada"), HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<PostsDto> listPosts(@PathVariable("user_id") Integer userId,@RequestParam(value="order",defaultValue = "") String order) {
        return new ResponseEntity<>(productServer.listPosts(userId,order),HttpStatus.OK);
    }

    ///// EXTRA //////

    @GetMapping("/{user_id}/promo-post/count")
    public ResponseEntity<PostsDto> promoCount(@PathVariable("user_id") Integer userId) {
        return new ResponseEntity<>(productServer.promoPostCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{user_id}/promo-post")
    public ResponseEntity<PostsDto> promoList(@PathVariable("user_id") Integer userId){
        return new ResponseEntity<>(productServer.promoList(userId),HttpStatus.OK);
    }
}
