package com.bootcamp.socialmeli.dto.response.post;

import com.bootcamp.socialmeli.dto.response.user.BasicUserInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellerProductsInPromoList extends BasicUserInfo {

    List<PostPromoOutDTO> posts;

    public SellerProductsInPromoList(int userId, String userName, List<PostPromoOutDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
