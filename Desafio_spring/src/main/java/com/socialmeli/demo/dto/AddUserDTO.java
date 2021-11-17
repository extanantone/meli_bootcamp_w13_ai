package com.socialmeli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDTO {

    private String userName;
    private String name;
    private String lastName;
}
