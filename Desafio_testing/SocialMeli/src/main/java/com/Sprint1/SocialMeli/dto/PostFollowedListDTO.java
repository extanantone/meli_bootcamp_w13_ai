package com.Sprint1.SocialMeli.dto;

import com.Sprint1.SocialMeli.dto.PostDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

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
                ", post=" + post +
                '}';
    }
}
