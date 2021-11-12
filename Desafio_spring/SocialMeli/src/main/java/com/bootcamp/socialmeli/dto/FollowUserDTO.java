package com.bootcamp.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowUserDTO {

    private long userId;
    private long userToFollowId;
}
