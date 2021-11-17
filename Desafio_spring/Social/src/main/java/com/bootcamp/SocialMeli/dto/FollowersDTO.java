package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Buyer;
import com.bootcamp.SocialMeli.model.Seller;
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

    int buyer_id;
    String buyer_name;
    List<Buyer> listFolloweds;

}
