package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.FollowersCountDTO;
import com.SocialMeli.SocialMeli.dto.SellersDTO;
import com.SocialMeli.SocialMeli.dto.UserDTO;

public interface IUserService {
    UserDTO createBuyers(UserDTO user);
    UserDTO createSellers(UserDTO user);
    Boolean followUser(Integer user_id, Integer user_id_to_follow);
    /*FollowersCountDTO followersCount( Integer user_id );
    SellersDTO followersList(Integer user_id);*/
}
