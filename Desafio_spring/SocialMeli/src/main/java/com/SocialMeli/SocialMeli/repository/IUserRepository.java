package com.SocialMeli.SocialMeli.repository;

import com.SocialMeli.SocialMeli.dto.FollowersCountDTO;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;

public interface IUserRepository {
    UserDTO createBuyers(UserDTO user);
    UserDTO createSellers(UserDTO user);
    UserDTO findBuyerByUserId(Integer user_id);
    UserDTO findSellerByUserId(Integer user_id);
    //Boolean follow(Integer user_id, Integer user_id_to_follow);
    /*FollowersCountDTO followersCount(Integer user_id);
    SellersDTO followersList(Integer user_id);*/
}
