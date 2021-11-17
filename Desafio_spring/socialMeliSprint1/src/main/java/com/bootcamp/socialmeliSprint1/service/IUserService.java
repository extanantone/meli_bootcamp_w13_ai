package com.bootcamp.socialmeliSprint1.service;

import com.bootcamp.socialmeliSprint1.dto.response.user.PurchaserFollowedListDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.SellerFollowersListDTO;

public interface IUserService {

    void addFollowed (Integer purchaserId, Integer sellerId);

    SellerFollowersInfoDTO getSellerFollowersCount (Integer sellerId);

    SellerFollowersListDTO getSellerFollowersList(Integer sellerId);

    PurchaserFollowedListDTO getPurchaserFollowedList(Integer purchaserId);

    void unFollow (Integer purchaserId, Integer sellerId);

    SellerFollowersListDTO getSellerFollowersListSort(Integer sellerId, String order);

    PurchaserFollowedListDTO getPurchaserFollowedListSort(Integer purchaserId, String order);


}
