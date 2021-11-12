package com.bootcamp.socialmeli.dto;

import com.bootcamp.socialmeli.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private long id;
    private String username;
}
