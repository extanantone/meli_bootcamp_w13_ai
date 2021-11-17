package com.socialmeli.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListPromoPostDTO {
    int user_id;
    String user_name;
    List<PostDTO> posts;

    public ListPromoPostDTO(int user_id,String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.posts = new ArrayList<>();
    }
}
