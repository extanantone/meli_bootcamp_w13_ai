package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;

public interface IUserService {
    public SellerCountFollowersDTO getSellerFollowersCount(int id);
    public FollowSellerDTO followSeller(int userId, int userToFollowId);
    public SellerFollowersDTO getFollowers(int sellerId, String order);
    public SellersFollowedDTO getFollowed(int buyerId);
    public UnfollowSellerDTO unfollowSeller(int userId, int userToUnfollowId);
}
