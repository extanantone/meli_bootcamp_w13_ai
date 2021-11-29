package com.socialmeli.demo.dto;

import com.socialmeli.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer userId;
    private String userName;
    private String name;
    private String lastName;
}
