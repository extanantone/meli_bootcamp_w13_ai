package com.example.socialmeli.dto;

import com.example.socialmeli.model.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class PostResponseDto extends UserDto{
    //TODO cambiar post a postDto
    List<Post> posts;

    public PostResponseDto(Integer user_id,String user_name,List<Post> posts) {
        this.posts = posts;
        super.user_id = user_id;
        super.user_name = user_name;
    }
}
