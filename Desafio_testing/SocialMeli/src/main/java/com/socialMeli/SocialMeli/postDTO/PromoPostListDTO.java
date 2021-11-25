package com.socialMeli.SocialMeli.postDTO;

import com.socialMeli.SocialMeli.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PromoPostListDTO {
    private Integer user_id;
    private String user_name;
    private List<PromoPostDTO> posts=new ArrayList<>();

    public PromoPostListDTO(Integer id, String username, List<Post> list1) {
        this.user_id=id;
        this.user_name=username;
        for (Post post:list1) {
            PromoPostDTO promoPostDTO=new PromoPostDTO(post);
            posts.add(promoPostDTO);
        }
    }
}
