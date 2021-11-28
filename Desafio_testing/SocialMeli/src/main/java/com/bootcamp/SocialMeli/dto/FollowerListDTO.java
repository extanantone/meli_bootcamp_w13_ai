package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.entity.User;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FollowerListDTO {

    private int user_id;
    private String user_name;
    private ArrayList<UserDTO> followers;

}
