package com.bootcamp.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePostDTO {
    private int userId;
    private List<PostDTO> posts;
}
