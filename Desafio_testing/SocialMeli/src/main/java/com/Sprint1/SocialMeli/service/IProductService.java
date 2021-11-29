package com.Sprint1.SocialMeli.service;

import com.Sprint1.SocialMeli.dto.PostFollowedListDTO;
import com.Sprint1.SocialMeli.dto.PostDTO;

public interface IProductService {
    void createPost (PostDTO post);
    PostFollowedListDTO postListFollowed(int user_id, String order);
}
