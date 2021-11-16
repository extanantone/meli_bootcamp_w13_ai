package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserPostDTO {
    private final Integer userId;
    private final List<PostListDTO> posts;

    public UserPostDTO(Integer userId) {
        this.userId = userId;
        this.posts = new ArrayList<>();
    }
}
