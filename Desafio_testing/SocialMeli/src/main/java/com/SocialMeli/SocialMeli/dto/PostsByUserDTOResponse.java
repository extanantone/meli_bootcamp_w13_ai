package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PostsByUserDTOResponse {
    private int user_id;
    private List<PostListItemDTOResponse> posts;
}
