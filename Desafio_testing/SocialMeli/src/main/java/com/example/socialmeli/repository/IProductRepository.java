package com.example.socialmeli.repository;

import com.example.socialmeli.dto.PostCreateDto;

import java.util.List;

public interface IProductRepository {
    public void createPost(PostCreateDto postCreateDto);
    public Boolean findById(Integer postId);
    public List<PostCreateDto> listPosts(Integer userId);

    List<PostCreateDto> promoPost(Integer userId);
}
