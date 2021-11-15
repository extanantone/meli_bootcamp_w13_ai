package com.SocialMeli.SocialMeli.dto;

import com.SocialMeli.SocialMeli.model.Post;
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
public class PostSellerDTO {
    private int user_id;
    private List<PostDTO> posts = new ArrayList<>();


    public PostSellerDTO(int user_id) {
        this.user_id = user_id;
    }
}
