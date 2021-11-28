package com.bootcamp.SocialMeli.dto;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FollowedListDTO {

    private int user_id;
    private String user_name;
    private ArrayList<UserDTO> followed;
}
