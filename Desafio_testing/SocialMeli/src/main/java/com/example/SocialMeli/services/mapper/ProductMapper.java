package com.example.SocialMeli.services.mapper;

import com.example.SocialMeli.dto.PostDTO;
import com.example.SocialMeli.entities.Post;

public class ProductMapper {

    public static Post toEntity(PostDTO postDTO) {
        return new Post(postDTO.getId(), postDTO.getUserId(), postDTO.getDate(), DetailMapper.toEntity(postDTO.getDetailDTO()), postDTO.getCategory(), postDTO.getPrice());
    }

    public static PostDTO toDto(Post post) {
        return new PostDTO(post.getId(), post.getUserId(), post.getDate(), DetailMapper.toDto(post.getDetail()), post.getCategory(), post.getPrice());
    }
}
