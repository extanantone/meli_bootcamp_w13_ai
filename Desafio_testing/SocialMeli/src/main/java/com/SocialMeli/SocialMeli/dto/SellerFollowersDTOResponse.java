package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SellerFollowersDTOResponse extends UserDTO{
    private List<UserDTO> followers;
}
