package com.bootcamp.socialmeli.dto.response.user;

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
public class PurchaserFollowedListDTO extends BasicUserInfo{

    List<BasicUserInfo> followed;

    public PurchaserFollowedListDTO(int userId, String userName, List<BasicUserInfo> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
