package com.Sprint1.SocialMeli.Model;

import com.Sprint1.SocialMeli.DTO.UserShortDTO;
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
public class User {

    private Integer userId;
    private String userName;
    private Boolean isSeller;
    private List<UserShortDTO> followeds;

}
