package com.example.socialmeli.controller.v1.product.post;

import com.example.socialmeli.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/v1/products")
public interface IPostController
{
    @PostMapping("/post")
    UserPostDTO createPost(@RequestBody UserPostDTO postDTO);

    @PostMapping("/promo-post")
    UserPromoPostDTO createPromoPost(@RequestBody UserPromoPostDTO promoPostDTO);

    @GetMapping("/followed/{userId}/list")
    ProductFollowedDTO recentFollowedProducts(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order);

    @GetMapping("/{userId}/promo-post/count")
    PromoPostCountDTO promoPostcount(@PathVariable int userId);
}
