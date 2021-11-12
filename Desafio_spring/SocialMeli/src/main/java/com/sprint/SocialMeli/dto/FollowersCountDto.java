package com.sprint.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FollowersCountDto {
    int user_id;
    String user_name;
    int followers_count;
}
