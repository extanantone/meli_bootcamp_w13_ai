package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.SellerFollowersInfoDTO;

public interface IUserService {

    boolean addFollowed (Integer purchaserId, Integer sellerId);

    SellerFollowersInfoDTO getSellerFollowers (Integer sellerId);


}
