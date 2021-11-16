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
public class FollowedSellerPostDTO {
    int user_id;
    List<PostWithoutDiscountDTO> posts;

    public FollowedSellerPostDTO(int user_id) {
        this.user_id = user_id;
        this.posts = new ArrayList<>();
    }
}
