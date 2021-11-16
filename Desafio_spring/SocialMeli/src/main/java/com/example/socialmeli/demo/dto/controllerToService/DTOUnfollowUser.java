package com.example.socialmeli.demo.dto.controllerToService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOUnfollowUser {

    private int user_id;
    private int user_id_to_unfollow;

}
