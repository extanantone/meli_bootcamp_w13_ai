package com.socialmeli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithFollowersCountDTO {

    private Integer userId;
    private String userName;
    private int followersCount;
}
