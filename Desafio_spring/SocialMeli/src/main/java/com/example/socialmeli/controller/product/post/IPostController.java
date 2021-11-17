package com.example.socialmeli.controller.product.post;

import com.example.socialmeli.dto.post.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("products")
public interface IPostController
{
    @PostMapping("/post")
    UserPostDTO createPost(@RequestBody UserPostDTO postDTO);

    @PostMapping("/promo-post")
    UserPromoPostDTO createPromoPost(@RequestBody UserPromoPostDTO promoPostDTO);

    @GetMapping("/followed/{userId}/list")
    PostFollowedDTO recentFollowedProducts(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order);

    @GetMapping("/{userId}/promo-post/count")
    PromoPostCountDTO promoPostcount(@PathVariable int userId);

    @GetMapping("{userId}/list")
    PromoPostListDTO promoPostList(@PathVariable int userId, @RequestParam(required = false) String order);
}
