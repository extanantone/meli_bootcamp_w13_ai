package com.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersDTO extends UserDTO {
    private List<UserDTO> followers = new ArrayList<>();

    public FollowersDTO(Integer userId, String userName) {
        super(userId, userName);
    }
}
