package com.SocialMeli.SocialMeli.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersDTO {

    private int user_id;
    private String user_name;
    private List<BuyersFollowedDTO> followers;
}
