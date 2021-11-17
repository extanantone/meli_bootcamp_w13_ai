package com.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FollowedUsersDTO extends UserDTO {
    private List<UserDTO> followedUsers = new ArrayList<>();

    public FollowedUsersDTO(int user_id, String user_name) {
        super(user_id, user_name);
    }
}
