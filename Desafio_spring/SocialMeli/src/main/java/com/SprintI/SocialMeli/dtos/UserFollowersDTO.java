package com.SprintI.SocialMeli.dtos;

import com.SprintI.SocialMeli.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class UserFollowersDTO {
    private int id;
    private String name;
    private List<UserDTO> followers;

    public UserFollowersDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.followers = user.getFollowers().stream().map(UserDTO::new).collect(Collectors.toList());
    }

}
