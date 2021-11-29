package com.example.SocialMeli.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersDTO {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
