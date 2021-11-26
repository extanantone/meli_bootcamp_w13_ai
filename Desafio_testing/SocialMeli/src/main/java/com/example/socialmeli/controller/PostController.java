package com.example.socialmeli.controller;

import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.dto.ResponseDto;
import com.example.socialmeli.exception.BadRequestException;
import com.example.socialmeli.dto.PostCreateDto;
import com.example.socialmeli.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {
    IProductService productServer;

    public PostController(IProductService productServer) {
        this.productServer = productServer;
    }


    @PostMapping(value= {"/post", "/promo-post"})
    public ResponseEntity<ResponseDto> createPost(@Valid @RequestBody PostCreateDto postCreateDto) {

        if(postCreateDto.getDiscount() == null && postCreateDto.getHasPromo()) {
            throw new BadRequestException("Ingresa un descuento a la promo");
        }

        productServer.createPost(postCreateDto);

        return new ResponseEntity<ResponseDto>(new ResponseDto("OK","Publicacion creada"), HttpStatus.OK);
    }

    @Valid
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
