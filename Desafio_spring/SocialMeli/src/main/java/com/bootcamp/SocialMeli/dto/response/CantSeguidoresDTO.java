package com.bootcamp.SocialMeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CantSeguidoresDTO extends UsuarioDTO{
    private Integer followersCount;

    public CantSeguidoresDTO(Integer userId, String userName, Integer followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
