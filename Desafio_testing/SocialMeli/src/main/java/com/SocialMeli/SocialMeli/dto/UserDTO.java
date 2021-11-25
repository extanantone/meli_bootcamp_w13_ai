package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer user_id;
    private String user_name;

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
