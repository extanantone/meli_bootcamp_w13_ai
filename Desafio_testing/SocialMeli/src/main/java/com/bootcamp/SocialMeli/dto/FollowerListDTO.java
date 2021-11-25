package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FollowerListDTO {

    private int user_id;
    private String user_name;
    private ArrayList<UserDTO> followers;

}
