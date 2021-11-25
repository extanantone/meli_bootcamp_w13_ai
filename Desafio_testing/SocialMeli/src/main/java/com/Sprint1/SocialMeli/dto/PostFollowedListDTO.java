package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor

public class PostFollowedListDTO {
    private int user_id;
    private List<PostDTO> post;

    public PostFollowedListDTO(int user_id, List<PostDTO> postList) {
        this.user_id = user_id;
        this.post = postList;
    }


    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", postList=" + post +
                '}';
    }
}
