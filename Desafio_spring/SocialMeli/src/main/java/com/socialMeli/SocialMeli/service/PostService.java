package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.postDTO.PromoPostDTO;
import com.socialMeli.SocialMeli.postDTO.PromoProductsCountDTO;

import java.util.HashMap;

public interface PostService {
    Post create(Post post, HashMap usersList);
    Post create(PromoPostDTO post, HashMap usersList);
    PostFollowedDTO productListFollowed(HashMap usersList,Integer user_id);
    PostFollowedDTO productListFollowed(HashMap usersList,Integer user_id, String date_desc);

    PromoProductsCountDTO promoProductsCount(Integer user_id, HashMap<Integer, User> list_users);
}
