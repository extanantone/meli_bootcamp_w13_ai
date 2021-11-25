package com.bootcamp.socialmeliSprint1.dto.response.user;

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
public class PurchaserFollowedListDTO extends BasicUserInfoDTO {

    List<BasicUserInfoDTO> followed;

    public PurchaserFollowedListDTO(int userId, String userName, List<BasicUserInfoDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
