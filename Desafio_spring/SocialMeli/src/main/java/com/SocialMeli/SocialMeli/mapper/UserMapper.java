package com.SocialMeli.SocialMeli.mapper;

import com.SocialMeli.SocialMeli.dto.*;
import com.SocialMeli.SocialMeli.entity.Buyer;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.SocialMeli.SocialMeli.entity.User;

import java.util.ArrayList;

public class UserMapper {
    public static Seller sellerDTOToSeller(SellerCountFollowersDTO sellerDTO){
        Seller seller = new Seller();
        seller.setId(sellerDTO.getUser_id());
        seller.setUserName(sellerDTO.getUser_name());
        return seller;
    }

    public static SellerCountFollowersDTO sellerToSellerDTO(Seller seller){
        SellerCountFollowersDTO sellerDTO = new SellerCountFollowersDTO();
        sellerDTO.setUser_id(seller.getId());
        sellerDTO.setUser_name(seller.getUserName());
        sellerDTO.setFollowers_count(seller.getFollowers().size());
        return sellerDTO;
    }

    public static SellerFollowersDTO sellerToSellerFollowersDTO(Seller seller){
        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        sellerFollowersDTO.setUser_id(seller.getId());
        sellerFollowersDTO.setUser_name(seller.getUserName());
        sellerFollowersDTO.setFollowers(new ArrayList<>());
        return sellerFollowersDTO;
    }

    public static Buyer buyerDTOToBuyer(BuyerDTO buyerDTO){
        Buyer buyer = new Buyer();
        buyer.setId(buyerDTO.getUser_id());
        buyer.setUserName(buyerDTO.getUser_name());
        return buyer;
    }

    public static BuyerDTO buyerToBuyerDTO(Buyer buyer){
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setUser_id(buyer.getId());
        buyerDTO.setUser_name(buyer.getUserName());
        return buyerDTO;
    }

    public static BuyerDTO userToBuyerDTO(User user){
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setUser_id(user.getId());
        buyerDTO.setUser_name(user.getUserName());
        return buyerDTO;
    }

    public static SellersFollowedDTO userToSellersFollowedDTO(User user){
        SellersFollowedDTO sellersFollowedDTO = new SellersFollowedDTO();
        sellersFollowedDTO.setUser_id(user.getId());
        sellersFollowedDTO.setUser_name(user.getUserName());
        sellersFollowedDTO.setFollowed(new ArrayList<>());
        return sellersFollowedDTO;
    }

    public static UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getId());
        userDTO.setUser_name(user.getUserName());
        return userDTO;
    }

    public static SellerCountPromosDTO userToSellerCountDTO(User seller){
        SellerCountPromosDTO sellerCountPromosDTO = new SellerCountPromosDTO();
        sellerCountPromosDTO.setUser_id(seller.getId());
        sellerCountPromosDTO.setUser_name(seller.getUserName());
        return sellerCountPromosDTO;
    }
}
