package com.SocialMeli.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PostsListDTO {
    @Setter
    private Integer userId;
    private final List<PostDTO> posts = new ArrayList<>();
}
