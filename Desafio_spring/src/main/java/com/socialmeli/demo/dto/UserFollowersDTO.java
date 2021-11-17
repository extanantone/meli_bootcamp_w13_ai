package com.socialmeli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followers;
}
