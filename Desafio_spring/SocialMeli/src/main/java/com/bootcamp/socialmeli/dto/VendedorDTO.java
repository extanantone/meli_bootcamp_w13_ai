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
public class VendedorDTO extends UserDTO{
    private List<UserDTO> followers;

    public VendedorDTO(long user_id, String user_name, List<UserDTO> followers) {
        super(user_id, user_name);
        this.followers = followers;
    }
}
