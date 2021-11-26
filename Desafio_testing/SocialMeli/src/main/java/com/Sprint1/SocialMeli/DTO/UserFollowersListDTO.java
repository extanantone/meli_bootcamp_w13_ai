package com.Sprint1.SocialMeli.DTO;

import com.Sprint1.SocialMeli.Model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowersListDTO {

    private Integer userId;
    private String userName;
    private List<UserShortDTO> followers;

    public UserFollowersListDTO (User usuario){
        this.userId = usuario.getUserId();
        this.userName = usuario.getUserName();
    }
}
