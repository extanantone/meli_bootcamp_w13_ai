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
public class FollowedsDTO {

    int user_id;
    String user_name;
    List<Seller> followers;

}


