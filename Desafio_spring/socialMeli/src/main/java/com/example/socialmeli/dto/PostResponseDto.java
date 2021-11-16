package com.example.socialmeli.dto;

import com.example.socialmeli.model.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PostResponseDto extends PostDto{
    //TODO cambiar post a postDto
    //TODO agregar super userid etc
    List<Post> posts;
}
