package com.socialMeli.SocialMeli.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
    private Integer user_id;
    private String user_name;

    public UserInfoDTO(Integer user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
