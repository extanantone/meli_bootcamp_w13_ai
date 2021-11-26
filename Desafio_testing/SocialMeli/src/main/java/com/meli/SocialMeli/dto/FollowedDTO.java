package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowedDTO extends UserDTO implements Serializable {
    private List<UserDTO> followed;

    public FollowedDTO(int userId, String userName){
        super(userId, userName);
        this.followed = new LinkedList<>();
    }
}
