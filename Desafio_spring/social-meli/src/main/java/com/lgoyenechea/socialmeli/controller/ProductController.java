package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.PostCreationDTO;
import com.lgoyenechea.socialmeli.dto.PostDTO;
import com.lgoyenechea.socialmeli.dto.UserFollowedPostsListDTO;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    ResponseEntity<PostDTO> newProductPost(@RequestBody PostCreationDTO newPost) {
        PostDTO post = productService.save(newPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    ResponseEntity<UserFollowedPostsListDTO> followedPostsList(@PathVariable Long userId,
                                                               @RequestParam(defaultValue = "date_asc") String order)
            throws UserArgumentNotValidException {
        UserFollowedPostsListDTO postsList = productService.followedPostsList(userId, order);
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }
}
