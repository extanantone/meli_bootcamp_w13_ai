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
public class UserCountDTO {
    private int id;
    private String name;
    private int quantityOfFollowed;

    public UserCountDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.quantityOfFollowed = user.getFollowers().size();
    }
}
