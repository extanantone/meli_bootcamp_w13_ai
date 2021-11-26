package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.UserNotFoundException;
import com.lgoyenechea.socialmeli.service.IProductService;
import org.jetbrains.annotations.NotNull;
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
    ResponseEntity<PostDTO> newProductPost(@RequestBody @Valid PostCreationDTO newPost)
            throws UserNotFoundException {
        PostDTO post = productService.save(newPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    ResponseEntity<UserFollowedPostsListDTO> followedPostsList(@PathVariable @NotNull Long userId,
                                                               @RequestParam(defaultValue = "date_asc",
                                                                                required = false) String order)
            throws UserNotFoundException {

        UserFollowedPostsListDTO postsList = productService.followedPostsList(userId, order);
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    ResponseEntity<PostPromoDTO> newProductWithPromoPost(@RequestBody @Valid PostCreationPromoDTO newPost)
            throws UserNotFoundException {

        PostPromoDTO post = productService.saveWithPromo(newPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{userId}/promo-post/count")
    ResponseEntity<UserPromoPostCountDTO> promoPostCount(@PathVariable @NotNull Long userId)
            throws UserNotFoundException {

        UserPromoPostCountDTO promoPostCount = productService.postsPromoCount(userId);
        return new ResponseEntity<>(promoPostCount, HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    ResponseEntity<UserPostsPromoListDTO> postsPromoList(@PathVariable @NotNull Long userId)
            throws UserNotFoundException {

        UserPostsPromoListDTO postsList = productService.postsPromoList(userId);
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }
}
