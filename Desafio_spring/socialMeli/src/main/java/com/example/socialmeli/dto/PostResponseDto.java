package com.example.socialmeli.dto;

import com.example.socialmeli.model.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class PostResponseDto extends UserDto{
    private List<PostDto> posts;

    public PostResponseDto(Integer userId,String userName,List<PostDto> posts) {
        this.posts = posts;
        super.setUserId(userId);
        super.setUserName(userName);
    }
}
