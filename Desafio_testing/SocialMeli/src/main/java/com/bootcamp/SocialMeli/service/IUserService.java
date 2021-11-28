package com.bootcamp.SocialMeli.service;


import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.entity.Buyer;
;
import com.bootcamp.SocialMeli.entity.Post;
import com.bootcamp.SocialMeli.entity.Seller;


import java.util.List;

public interface IUserService {

    List<Buyer> getBuyerList();
    List<Seller> getSellerList();
    Buyer findBuyerById(int userId);
    Seller findSellerById(int userId);

    boolean follow(int user_id, int user_id_to_follow);
    FollowersCountDTO count(int user_id);
    FollowerListDTO followers(int user_id, String order);
    FollowedListDTO followed(int user_id, String order);
    boolean newPost(PostDTO post);


    PostFollowedListDTO followedSellersPost(int user_id, String order);

    boolean unFollow(int user_id, int user_id_to_unfollow);
}

