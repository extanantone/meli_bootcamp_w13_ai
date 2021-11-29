package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostsListDTO {
    private Integer userId;
    private List<PostDTO> posts;

    public PostsListDTO(Integer userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

}

