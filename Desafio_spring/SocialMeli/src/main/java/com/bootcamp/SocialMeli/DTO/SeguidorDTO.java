package com.bootcamp.SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeguidorDTO {
    private Integer idUser;
    private String userName;
    private Integer idUserFollow;
    private String nameFollowed;

    public SeguidorDTO(String userName, Integer idUser, String nameFollowed, Integer idUserFollow) {
        this.userName=userName;
        this.idUser=idUser;
        this.idUserFollow=idUserFollow;
        this.nameFollowed=nameFollowed;
    }
}
