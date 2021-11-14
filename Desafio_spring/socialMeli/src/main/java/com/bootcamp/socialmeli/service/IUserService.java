package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.post.PostInDTO;
import com.bootcamp.socialmeli.dto.response.user.PurchaserFollowedListDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeli.dto.response.user.SellerFollowersListDTO;

public interface IUserService {

    void addFollowed (Integer purchaserId, Integer sellerId);

    SellerFollowersInfoDTO getSellerFollowersCount (Integer sellerId);

    SellerFollowersListDTO getSellerFollowersList(Integer sellerId);

    PurchaserFollowedListDTO getPurchaserFollowedList(Integer purchaserId);




}
