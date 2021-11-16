package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompradorDTO extends UserDTO {
    private List<UserDTO> followed;

    public CompradorDTO(long userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }

    public CompradorDTO(List<UserDTO> followed) {
        this.followed = followed;
    }
}
