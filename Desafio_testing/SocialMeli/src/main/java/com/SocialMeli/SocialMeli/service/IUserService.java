package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;

public interface IUserService {
    public SellerCountFollowersDTOResponse getSellerFollowersCount(int id);
    public MessageDTOResponse followSeller(int userId, int userToFollowId);
    public SellerFollowersDTOResponse getFollowers(int sellerId, String order);
    public SellersFollowedDTOResponse getFollowed(int buyerId, String order);
    public MessageDTOResponse unfollowSeller(int userId, int userToUnfollowId);
}
