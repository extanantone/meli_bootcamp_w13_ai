package com.example.socialmeli.dto.response;

import com.example.socialmeli.dto.UserDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersResponseDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followers;

}
