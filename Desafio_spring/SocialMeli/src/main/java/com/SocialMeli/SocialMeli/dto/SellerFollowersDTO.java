package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SellerFollowersDTO {
    private int user_id;
    private String user_name;
    private List<BuyerDTO> followers;
}
