package com.bootcamp.socialmeli.dto;

import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserListDTO {
    private List<UserDTO> userListDTO = new ArrayList<>();
}
