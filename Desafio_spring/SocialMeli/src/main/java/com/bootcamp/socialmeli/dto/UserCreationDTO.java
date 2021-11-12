package com.bootcamp.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreationDTO {

    private String username;
    private String email;
    private String password;
}
