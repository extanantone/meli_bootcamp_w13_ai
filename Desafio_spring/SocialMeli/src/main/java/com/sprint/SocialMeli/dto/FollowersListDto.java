package com.sprint.SocialMeli.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FollowersListDto {
    int user_id;
    String user_name;
    List<UserDto> followers;
}
