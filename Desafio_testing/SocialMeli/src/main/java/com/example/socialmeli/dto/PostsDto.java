package com.example.socialmeli.dto;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostsDto {


    private Integer userId;

    private String userName;

    private List<PostDto> posts;
    private Integer promoProductsCount;

    public PostsDto(Integer userId, List<PostDto> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public PostsDto(Integer userId, Integer promoProductsCount) {
        this.userId = userId;
        this.promoProductsCount = promoProductsCount;
    }

    public PostsDto(User user, List<PostDto> posts) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.posts = posts;
    }


}
