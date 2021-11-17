package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.*;

import java.util.HashMap;

public interface PostService {
    Post create(Post post, HashMap usersList);
    Post create(PromoPostInDTO post, HashMap usersList);
    PostFollowedDTO productListFollowed(HashMap usersList,Integer user_id);
    PostFollowedDTO productListFollowed(HashMap usersList,Integer user_id, String date_desc);

    PromoProductsCountDTO promoProductsCount(Integer user_id, HashMap<Integer, User> list_users);

    PromoPostListDTO promoProductsList(Integer user_id, HashMap<Integer, User> list_users);
}
