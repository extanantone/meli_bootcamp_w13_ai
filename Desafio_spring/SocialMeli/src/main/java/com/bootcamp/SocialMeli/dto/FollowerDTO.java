package com.bootcamp.SocialMeli.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FollowerDTO extends UserDTO implements Serializable {
private List<UserDTO> follower;

public FollowerDTO(Integer user_id, String user_name, List<UserDTO> follower){
    super(user_id, user_name);
    this.follower = follower;
}
}


