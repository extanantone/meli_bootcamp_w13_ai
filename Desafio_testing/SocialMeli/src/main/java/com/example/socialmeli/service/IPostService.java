package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDTO;
import com.example.socialmeli.dto.PromoCountDTO;
import com.example.socialmeli.dto.PromoPostDTO;
import com.example.socialmeli.dto.UserPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPostService {
    void addPost(Integer userId, Integer postId, PostDTO post);
    UserPostDTO getPosts(Integer userId, String order);
    void addPromoPost(Integer userId, Integer postId, PromoPostDTO post);
    PromoCountDTO getPromoCount(Integer userId);
}
