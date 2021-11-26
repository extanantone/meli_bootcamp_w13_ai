package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.dto.PostCreateDto;


public interface IProductService {

    public void createPost(PostCreateDto postCreateDto);


    PostsDto listPosts(Integer userId,String order);

    PostsDto promoPostCount(Integer userId);

    PostsDto promoList(Integer userId);
}
