package com.bootcamp.socialmeli.dto;

import com.bootcamp.socialmeli.model.User;
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
public class VendedorDTO extends UserDTO {
    private List<UserDTO> followers;

    public VendedorDTO(long userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }

    public VendedorDTO(List<UserDTO> followers) {
        this.followers = followers;
    }
}
