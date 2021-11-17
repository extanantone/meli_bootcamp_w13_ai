package com.bootcamp.socialmeliSprint1.dto.response.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellerFollowersInfoDTO extends BasicUserInfoDTO {
    private int followersCount;
    public SellerFollowersInfoDTO(int userId, String userName, int followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
