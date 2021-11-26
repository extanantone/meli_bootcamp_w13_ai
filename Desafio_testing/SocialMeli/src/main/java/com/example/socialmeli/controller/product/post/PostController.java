package com.example.socialmeli.controller.product.post;

import com.example.socialmeli.dto.post.*;
import com.example.socialmeli.service.service.product.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements IPostController
{

    @Autowired
    IPostService postService;

    @Override
    public UserPostDTO createPost(UserPostDTO postDTO)
    {
        return postService.create(postDTO);
    }

    @Override
    public PromoPostListDTO promoPostList(int userId, String order)
    {
        return postService.promoPostList(userId, order);
    }

    @Override
    public PromoPostCountDTO promoPostcount(int userId)
    {
        return postService.promoPostCount(userId);
    }

    @Override
    public UserPromoPostDTO createPromoPost(UserPromoPostDTO promoPostDTO)
    {
        return postService.createPromo(promoPostDTO);
    }

    @Override
    public PostFollowedDTO postList(int userId)
    {
        return postService.listPosts(userId);
    }

    @Override
    public PostFollowedDTO recentFollowedProducts(int userId, String order)
    {
        return postService.listRecentFollowedPosts(userId, order);
    }

}
