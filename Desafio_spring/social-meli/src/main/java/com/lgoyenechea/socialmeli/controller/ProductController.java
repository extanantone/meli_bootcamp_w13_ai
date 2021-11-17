package com.lgoyenechea.socialmeli.controller;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.exception.ProductArgumentNotValidException;
import com.lgoyenechea.socialmeli.exception.UserArgumentNotValidException;
import com.lgoyenechea.socialmeli.exception.UserDoesNotExistsException;
import com.lgoyenechea.socialmeli.service.IProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    private void validateId(Long id) throws UserArgumentNotValidException {
        if (id < 1) throw new UserArgumentNotValidException("Invalid user id.");
    }

    private void validateDate(String dateString) throws ProductArgumentNotValidException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            if (date.isAfter(LocalDate.now()))
                throw new ProductArgumentNotValidException("Invalid date.");
        } catch (DateTimeParseException e) {
            throw new ProductArgumentNotValidException("Invalid date format.");
        }
    }

    @PostMapping("/post")
    ResponseEntity<PostDTO> newProductPost(@RequestBody PostCreationDTO newPost)
            throws UserDoesNotExistsException, ProductArgumentNotValidException {

        validateDate(newPost.getDate());
        PostDTO post = productService.save(newPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    ResponseEntity<UserFollowedPostsListDTO> followedPostsList(@PathVariable @NotNull Long userId,
                                                               @RequestParam(defaultValue = "date_asc",
                                                                                required = false) String order)
            throws UserArgumentNotValidException, UserDoesNotExistsException{

        validateId(userId);
        UserFollowedPostsListDTO postsList = productService.followedPostsList(userId, order);
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    ResponseEntity<PostPromoDTO> newProductWithPromoPost(@RequestBody PostCreationPromoDTO newPost)
            throws UserDoesNotExistsException, ProductArgumentNotValidException {

        validateDate(newPost.getDate());
        PostPromoDTO post = productService.saveWithPromo(newPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{userId}/promo-post/count")
    ResponseEntity<UserPromoPostCountDTO> promoPostCount(@PathVariable @NotNull Long userId)
            throws UserArgumentNotValidException, UserDoesNotExistsException {

        validateId(userId);
        UserPromoPostCountDTO promoPostCount = productService.postsPromoCount(userId);
        return new ResponseEntity<>(promoPostCount, HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    ResponseEntity<UserPostsPromoListDTO> postsPromoList(@PathVariable @NotNull Long userId)
            throws UserArgumentNotValidException, UserDoesNotExistsException {

        validateId(userId);
        UserPostsPromoListDTO postsList = productService.postsPromoList(userId);
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }
}
