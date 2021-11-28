package com.bootcamp.SocialMeli.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFollowedListDTO {

    private int user_id;
    private List<PostListDTO> posts;

    public PostFollowedListDTO(int user_id){
        this.user_id = user_id;
        this.posts = new ArrayList<>();
    }

    public void addPost(PostListDTO post){
        this.posts.add(post);
    }
}
