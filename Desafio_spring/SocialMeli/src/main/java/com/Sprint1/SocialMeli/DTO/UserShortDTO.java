package com.Sprint1.SocialMeli.DTO;

import com.Sprint1.SocialMeli.Model.User;
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
public class UserShortDTO {

    private int userId;
    private String userName;

    public UserShortDTO (User usuario){
        this.userId = usuario.getUserId();
        this.userName = usuario.getUserName();
    }

}
