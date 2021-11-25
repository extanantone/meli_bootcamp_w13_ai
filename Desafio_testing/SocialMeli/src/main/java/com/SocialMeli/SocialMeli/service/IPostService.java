package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.*;

public interface IPostService {
    public PostDTORequest getById(int id);
    public MessageDTOResponse create(PostDTORequest postDTORequest);
    public PostsByUserDTOResponse getByUser(int userId, String order);
    public MessageDTOResponse createPromo(PostPromoDTORequest postPromoDTORequest);
    public PostPromoByUserDTOResponse getPromosByUser(int userId);
    public SellerCountPromosDTOResponse getSellerPromosCount(int sellerId);
}
