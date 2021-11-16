package com.SocialMeli.SocialMeli.mapper;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;

import java.util.ArrayList;

public class UserMapper {
    public static Seller sellerDTOToSeller(SellerCountFollowersDTOResponse sellerDTO){
        Seller seller = new Seller();
        seller.setId(sellerDTO.getUser_id());
        seller.setUserName(sellerDTO.getUser_name());
        return seller;
    }

    public static SellerCountFollowersDTOResponse sellerToSellerDTO(Seller seller){
        SellerCountFollowersDTOResponse sellerDTO = new SellerCountFollowersDTOResponse();
        sellerDTO.setUser_id(seller.getId());
        sellerDTO.setUser_name(seller.getUserName());
        sellerDTO.setFollowers_count(seller.getFollowers().size());
        return sellerDTO;
    }

    public static SellerFollowersDTOResponse sellerToSellerFollowersDTO(Seller seller){
        SellerFollowersDTOResponse sellerFollowersDTOResponse = new SellerFollowersDTOResponse();
        sellerFollowersDTOResponse.setUser_id(seller.getId());
        sellerFollowersDTOResponse.setUser_name(seller.getUserName());
        sellerFollowersDTOResponse.setFollowers(new ArrayList<>());
        return sellerFollowersDTOResponse;
    }

    public static SellersFollowedDTOResponse userToSellersFollowedDTO(User user){
        SellersFollowedDTOResponse sellersFollowedDTOResponse = new SellersFollowedDTOResponse();
        sellersFollowedDTOResponse.setUser_id(user.getId());
        sellersFollowedDTOResponse.setUser_name(user.getUserName());
        sellersFollowedDTOResponse.setFollowed(new ArrayList<>());
        return sellersFollowedDTOResponse;
    }

    public static UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getId());
        userDTO.setUser_name(user.getUserName());
        return userDTO;
    }

    public static SellerCountPromosDTOResponse userToSellerCountDTO(User seller){
        SellerCountPromosDTOResponse sellerCountPromosDTOResponse = new SellerCountPromosDTOResponse();
        sellerCountPromosDTOResponse.setUser_id(seller.getId());
        sellerCountPromosDTOResponse.setUser_name(seller.getUserName());
        return sellerCountPromosDTOResponse;
    }
}
