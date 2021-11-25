package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.PostFollowedListDTO;
import com.Sprint1.SocialMeli.model.Post;

public interface IProductService {
    void createPost (Post post);
    PostFollowedListDTO postListFollowed(int user_id, String order);
}
