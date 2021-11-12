package com.socialmeli.service;

import com.socialmeli.dto.SellerFollowersCountDto;
import com.socialmeli.dto.SellerFollowersCountDto;

public interface IUserService {

    void followUser(int idUser,int idSeller);
    SellerFollowersCountDto getCountBySeller(int idSeller);

}
