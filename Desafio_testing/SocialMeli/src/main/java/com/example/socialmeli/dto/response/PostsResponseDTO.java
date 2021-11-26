package com.example.socialmeli.dto.response;

import com.example.socialmeli.dto.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostsResponseDTO {

    private Integer userId;
    private List<PostDTO> posts;

}
