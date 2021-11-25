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
public class SellerFollowersListDTO extends BasicUserInfoDTO {

    List<BasicUserInfoDTO> followers;

    public SellerFollowersListDTO(int userId, String userName, List<BasicUserInfoDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
