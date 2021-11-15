package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;

public interface IPostService {
    public PostDTO getById(int id);
    public PostDTO create(PostDTO postDTO);
    public PostsByUserDTO getByUser(int userId, String order);
    public PostPromoDTO createPromo(PostPromoDTO postPromoDTO);
    public PostPromoByUserDTO getPromosByUser(int userId);
    public SellerCountPromosDTO getSellerPromosCount(int sellerId);
}
