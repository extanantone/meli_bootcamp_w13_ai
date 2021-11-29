package com.example.socialmeli.dto.response;

import com.example.socialmeli.dto.UserDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowedResponseDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followed;

}
