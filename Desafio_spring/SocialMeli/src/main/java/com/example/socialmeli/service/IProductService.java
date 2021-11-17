package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.model.Post;


public interface IProductService {

    public void createPost(Post post);


    PostsDto listPosts(Integer userId,String order);

    PostsDto promoPostCount(Integer userId);

    PostsDto promoList(Integer userId);
}
