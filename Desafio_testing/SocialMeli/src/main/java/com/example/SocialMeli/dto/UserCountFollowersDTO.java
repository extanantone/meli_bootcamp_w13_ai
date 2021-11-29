package com.example.SocialMeli.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCountFollowersDTO {
    private Long user_id;
    private String user_name;
    private int followers_count;
}
