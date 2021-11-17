package com.bootcamp.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FollowedDTO extends UserDTO implements Serializable {
private List<UserDTO> followed;

public FollowedDTO (Integer user_id, String user_name, List<UserDTO> followed){
    super(user_id, user_name);
    this.followed = followed;
}
}
