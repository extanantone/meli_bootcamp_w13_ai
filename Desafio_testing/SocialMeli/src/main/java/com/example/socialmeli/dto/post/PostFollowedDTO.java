package com.example.socialmeli.dto.post;

import com.example.socialmeli.dto.post.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostFollowedDTO
{
    private int userId;
    private List<PostDTO> posts;
}
