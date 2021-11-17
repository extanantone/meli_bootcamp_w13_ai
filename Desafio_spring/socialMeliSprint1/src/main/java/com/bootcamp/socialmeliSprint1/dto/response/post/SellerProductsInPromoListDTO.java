package com.bootcamp.socialmeliSprint1.dto.response.post;

import com.bootcamp.socialmeliSprint1.dto.response.user.BasicUserInfoDTO;
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
public class SellerProductsInPromoListDTO extends BasicUserInfoDTO {

    List<PostPromoOutDTO> posts;

    public SellerProductsInPromoListDTO(int userId, String userName, List<PostPromoOutDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
