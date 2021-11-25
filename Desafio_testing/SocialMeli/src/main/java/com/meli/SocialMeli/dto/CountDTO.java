package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CountDTO extends UserDTO implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer followersCount;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer productPromoCount;

    public CountDTO(int userId, String userName, Integer followersCount, Integer productPromoCount){
        super(userId, userName);
        this.followersCount=followersCount;
        this.productPromoCount = productPromoCount;
    }
}
