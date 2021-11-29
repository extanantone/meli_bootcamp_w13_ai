package com.example.socialmeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CountFollowersResponseDTO {

    private Integer userId;
    private String userName;
    private Integer followersCount;

}
