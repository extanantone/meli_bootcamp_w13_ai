package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersListDTO;

public interface IUserService {

    boolean addFollowed (Integer purchaserId, Integer sellerId);

    SellerFollowersInfoDTO getSellerFollowersCount (Integer sellerId);

    SellerFollowersListDTO getSellerFollowersList(Integer sellerId);


}
