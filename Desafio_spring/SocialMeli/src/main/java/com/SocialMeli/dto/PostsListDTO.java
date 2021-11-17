package com.SocialMeli.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostsListDTO {
    @Setter
    private int userId;
    private final List<PostDTO> posts = new ArrayList<>();
}
