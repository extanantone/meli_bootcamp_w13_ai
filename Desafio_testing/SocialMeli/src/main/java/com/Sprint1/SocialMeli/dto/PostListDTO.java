package com.Sprint1.SocialMeli.dto;

import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PostListDTO {
    private int user_id;
    private ArrayList<PostDTO> postList;
}
