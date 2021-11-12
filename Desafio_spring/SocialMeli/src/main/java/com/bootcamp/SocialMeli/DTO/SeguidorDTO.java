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
    private int idUser;
    private String userName;
    private int idUserFollow;
    private String nameFollowed;

    public SeguidorDTO(String userName, int idUser, String nameFollowed, int idUserFollow) {
        this.userName=userName;
        this.idUser=idUser;
        this.idUserFollow=idUserFollow;
        this.nameFollowed=nameFollowed;
    }
}
