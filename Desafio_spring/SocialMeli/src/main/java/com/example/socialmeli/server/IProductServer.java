package com.example.socialmeli.server;

import com.example.socialmeli.dto.PostsDto;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;


public interface IProductServer {

    public void createPost(Post post);


    PostsDto listPosts(Integer userId,String order);

    PostsDto promoPostCount(Integer userId);

    PostsDto promoList(Integer userId);
}
