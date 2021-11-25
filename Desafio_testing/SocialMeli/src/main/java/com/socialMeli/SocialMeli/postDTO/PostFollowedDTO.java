package com.socialMeli.SocialMeli.postDTO;

import com.socialMeli.SocialMeli.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostFollowedDTO {
    private Integer user_id;
    private List<PostDTO> posts=new ArrayList<>();

    public PostFollowedDTO(Integer user_id, List<Post> productListFollowed) {
        this.user_id=user_id;
        for (Post post: productListFollowed
             ) {
            PostDTO postDTO=new PostDTO(post);
            posts.add(postDTO);
        }
    }
}
