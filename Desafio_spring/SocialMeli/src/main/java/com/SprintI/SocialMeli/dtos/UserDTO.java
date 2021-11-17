package com.SprintI.SocialMeli.dtos;

import com.SprintI.SocialMeli.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
